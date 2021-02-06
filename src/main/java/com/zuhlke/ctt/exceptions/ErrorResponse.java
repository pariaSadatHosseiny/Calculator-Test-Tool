package com.zuhlke.ctt.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:37 PM
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;

}
