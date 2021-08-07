package com.example.pc_remote_control.controller;

import com.example.pc_remote_control.dto.PcRemoteStartResponseDto;
import com.example.pc_remote_control.responseStatus.ResponseStatusSet;
import com.example.pc_remote_control.util.WakeOnLan;
import com.example.pc_remote_control.vo.PcRemoteStartRequestVo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(value = "/remote_start/win_desktop")
public class PcRemoteStartController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public PcRemoteStartResponseDto startWinPc(@RequestBody PcRemoteStartRequestVo pcRemoteStartRequestVoe) {
        PcRemoteStartResponseDto pcRemoteStartResponseDto = new PcRemoteStartResponseDto();

        try {
            WakeOnLan wakeOnLan = new WakeOnLan();
            wakeOnLan.wakeUpPC(pcRemoteStartRequestVoe.getTargetDeviceMACAddress(),pcRemoteStartRequestVoe.getBroadcastAddress());
        } catch (IOException e) {
            pcRemoteStartResponseDto.setResponseStatus(ResponseStatusSet.PC_REMOTE_START_FAIL);
            pcRemoteStartResponseDto.setData(e.getMessage());
            return pcRemoteStartResponseDto;
        }

        pcRemoteStartResponseDto.setResponseStatus(ResponseStatusSet.PC_REMOTE_START_SUCCESS);
        pcRemoteStartResponseDto.setData("Not Error / Exception");
        return pcRemoteStartResponseDto;
    }

}

