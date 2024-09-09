package com.business.configuration.framework.exception;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.standard.enums.BasicResponseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * <b> ApplicationException </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
@Slf4j
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ApplicationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6390473997606500221L;

    private final BasicResponseType errorCode;
    private String resultMessage;


    public ApplicationException(Throwable t) {
        super(t);
        errorCode = BasicErrorCode.INTERNAL_SERVER_ERROR;
        resultMessage = errorCode.getDescription();
    }
}
