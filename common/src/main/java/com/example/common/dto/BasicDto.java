package com.example.common.dto;

import com.example.common.responseStatus.CommonBasicResponseStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasicDto<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date responseTime = new Date();
    private boolean isSuccess;
    private Integer responseCode;
    private String responseMessage;

    private T data;

    public void setResponseStatus(CommonBasicResponseStatus responseStatus) {
        this.isSuccess = responseStatus.isSuccess();
        this.responseCode = responseStatus.getResponseCode();
        this.responseMessage = responseStatus.getResponseMessage();
    }

}
