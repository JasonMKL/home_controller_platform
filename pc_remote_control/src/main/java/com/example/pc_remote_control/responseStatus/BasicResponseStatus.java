package com.example.pc_remote_control.responseStatus;

import com.example.common.responseStatus.CommonBasicResponseStatus;

public class BasicResponseStatus extends CommonBasicResponseStatus {

    public BasicResponseStatus(Integer code, String sysMessage, boolean isSuccess) {
        super(code, sysMessage, isSuccess);
    }

}
