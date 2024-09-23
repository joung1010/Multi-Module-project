package com.business.configuration.framework.exception.handler;

import com.business.configuration.framework.exception.BusinessException;
import com.business.configuration.framework.standard.http.CoreHttpResponseEntity;
import com.business.configuration.framework.standard.http.body.CoreHttpResponseBodyEntity;
import com.business.configuration.framework.standard.http.provider.CoreHttpResponseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <b> GlobalExceptionHandler </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */
@Slf4j
@RestControllerAdvice(annotations = RestApiController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public CoreHttpResponseEntity<CoreHttpResponseBodyEntity<Object>> handleBusinessException(BusinessException ex) {
        log.error("BusinessException occurred: {}", ex.getMessage());

        return CoreHttpResponseProvider.responseFail(ex.getErrorCode());
    }

}
