package com.example.common.responseStatus;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommonBasicResponseStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean isSuccess;
    private Integer responseCode;
    private String responseMessage;

    public CommonBasicResponseStatus(Integer code, String responseMessage, boolean isSuccess) {
        this.responseCode = code;
        this.responseMessage = responseMessage;
        this.isSuccess = isSuccess;
    }

}
