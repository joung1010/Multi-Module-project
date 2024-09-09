package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.standard.enums.BasicResponseType;
import com.business.configuration.framework.utils.StringToolkits;

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
    public BusinessException(BasicResponseType errorCode,String resultMessage) {
        super(errorCode, StringToolkits.defaultString(resultMessage,errorCode.getDescription()));
    }
    public BusinessException(String resultMessage) {
        super(BasicErrorCode.INTERNAL_SERVER_ERROR, resultMessage);
    }

}
