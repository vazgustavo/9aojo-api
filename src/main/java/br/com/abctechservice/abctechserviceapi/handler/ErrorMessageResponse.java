package br.com.abctechservice.abctechserviceapi.handler;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessageResponse {
    private Integer statusCode;
    private Date timeStamp;
    private String messsage;
    private String description;
}