package com.zuhlke.ctt.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Custom Exception which returns exception code and a message with the exception cause
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestCustomException extends Exception {

    public RestCustomException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }

    private String errCode;

}
