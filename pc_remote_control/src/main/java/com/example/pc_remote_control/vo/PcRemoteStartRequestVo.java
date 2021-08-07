package com.example.pc_remote_control.vo;

import lombok.Data;

@Data
public class PcRemoteStartRequestVo {

    private String targetDeviceMACAddress;

    private String broadcastAddress;

}
