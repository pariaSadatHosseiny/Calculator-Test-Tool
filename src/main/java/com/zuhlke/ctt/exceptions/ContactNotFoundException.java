package com.zuhlke.ctt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:35 PM
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Contact not found")
public class ContactNotFoundException extends RuntimeException {
}