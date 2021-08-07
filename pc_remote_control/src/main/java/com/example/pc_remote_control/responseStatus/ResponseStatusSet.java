package com.example.pc_remote_control.responseStatus;

// @Data is define at BasicResponseStatus
public class ResponseStatusSet {

    public static final BasicResponseStatus PC_REMOTE_START_SUCCESS
            = new BasicResponseStatus(2000000, "Remote Start Success", true);

    public static final BasicResponseStatus PC_REMOTE_START_FAIL
            = new BasicResponseStatus(4000000, "Remote Start Fail", false);

}
