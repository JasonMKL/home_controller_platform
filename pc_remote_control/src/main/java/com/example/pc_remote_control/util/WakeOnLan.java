package com.example.pc_remote_control.util;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class WakeOnLan {

    public void wakeUpPC(String targetDeviceMACAddress, String broadcastAddress) throws IOException {
        String magicPackageHead = "FFFFFFFFFFFF";
        String magicPackageContent = null;

        for (int i=0; i<16;  i++){
            if(i==0){
                magicPackageContent = magicPackageHead;
            }
            magicPackageContent += targetDeviceMACAddress;
        }

        sendMagicPackage(magicPackageContent, broadcastAddress);
    }

    private void sendMagicPackage(String packageContent, String broadcastAddress){
        byte[] data = hexStringToBytes(packageContent);
        try {
            DatagramSocket datagramSocket=new DatagramSocket();
            DatagramPacket datagramPacket=new DatagramPacket(
                    data,0,
                    data.length,
                    InetAddress.getByName(broadcastAddress),
                    34567
            );
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }

        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] result = new byte[length];

        for (int i = 0; i < length; i++) {
            int position = i * 2;
            result[i] = (byte) (charToByte(hexChars[position]) << 4 | charToByte(hexChars[position + 1]));
        }
        return result;
    }

    private byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
