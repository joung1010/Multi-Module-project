package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;

import java.io.Serial;

/**
 * <b> BusinessException </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
public class BusinessException extends ApplicationException {
    @Serial
    private static final long serialVersionUID = 3154775009200389547L;

    public BusinessException() {
        super(BasicErrorCode.INTERNAL_SERVER_ERROR);
    }
    public BusinessException(String resultMessage) {
        super(BasicErrorCode.INTERNAL_SERVER_ERROR, resultMessage);
    }
    public BusinessException(Throwable t) {
        super(BasicErrorCode.INTERNAL_SERVER_ERROR, t);
    }
}
