package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.standard.enums.BasicResponseType;

import java.io.Serial;

/**
 * <b> BadRequestException </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-23
 */
public class BadRequestException extends ApplicationException{

    @Serial
    private static final long serialVersionUID = -4304201562663985643L;

    public BadRequestException() {
        super(BasicErrorCode.INVALID_INPUT_VALUE);
    }

    public BadRequestException(BasicResponseType errorCode, String resultMessage) {
        super(errorCode, resultMessage);
    }
    public BadRequestException( String resultMessage) {
        super(BasicErrorCode.INVALID_INPUT_VALUE, resultMessage);
    }
}
