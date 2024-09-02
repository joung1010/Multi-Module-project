package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;

import java.io.Serial;

/**
 * <b> AuthorizationException </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
public class AuthorizationException extends ApplicationException {
    @Serial
    private static final long serialVersionUID = 7528175547741449949L;

    public AuthorizationException() {
        super(BasicErrorCode.ACCESS_DENIED);
    }
    public AuthorizationException(String resultMessage) {
        super(BasicErrorCode.ACCESS_DENIED, resultMessage);
    }

    public AuthorizationException(Throwable t) {
        super(BasicErrorCode.ACCESS_DENIED,t);
    }
}
