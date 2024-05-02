package com.pecastech.app.infra;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionDto {
    private Date timestamp = new Date();
    private String status = "Error";
    private int code;
    private HttpStatus stausCode;
    private String messageError;

    ExceptionDto(HttpStatus httpStatus, String params){
        this.stausCode = httpStatus;
        this.code = httpStatus.value();
        this.messageError = params;
    }

}