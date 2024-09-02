package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;

import java.io.Serial;

/**
 * <b> AuthenticationException </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
public class AuthenticationException extends ApplicationException{

    @Serial
    private static final long serialVersionUID = 614095820016645465L;

    public AuthenticationException() {
        super(BasicErrorCode.UNAUTHORIZED);
    }
    public AuthenticationException(String resultMessage) {
        super(BasicErrorCode.UNAUTHORIZED, resultMessage);
    }

    public AuthenticationException(Throwable t) {
        super(BasicErrorCode.UNAUTHORIZED,t);
    }
}
