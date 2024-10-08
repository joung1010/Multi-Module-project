package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.utils.StringToolkits;

import java.io.Serial;

/**
 * <b> DatabaseException </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
public class DatabaseException extends ApplicationException {
    @Serial
    private static final long serialVersionUID = -689858952639860122L;

    public DatabaseException() {
        super(BasicErrorCode.DATABASE_ERROR);
    }
    public DatabaseException(String resultMessage) {
        super(BasicErrorCode.DATABASE_ERROR, StringToolkits.defaultString(resultMessage,BasicErrorCode.DATABASE_ERROR.getDescription()));
    }


}
