package com.business.configuration.framework.exception.handler;

import com.business.configuration.framework.exception.*;
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

    @ExceptionHandler(BadRequestException.class)
    public CoreHttpResponseEntity<CoreHttpResponseBodyEntity<Object>> handleBadRequestException(BadRequestException ex) {
        log.error("BadRequestException occurred: {}", ex.getMessage());

        return CoreHttpResponseProvider.responseFail(ex.getErrorCode());
    }

    @ExceptionHandler(DatabaseException.class)
    public CoreHttpResponseEntity<CoreHttpResponseBodyEntity<Object>> handleDatabaseException(DatabaseException ex) {
        log.error("DatabaseException occurred: {}", ex.getMessage());

        return CoreHttpResponseProvider.responseFail(ex.getErrorCode());
    }

    @ExceptionHandler(AuthorizationException.class)
    public CoreHttpResponseEntity<CoreHttpResponseBodyEntity<Object>> handleAuthorizationException(AuthorizationException ex) {
        log.error("AuthorizationException occurred: {}", ex.getMessage());

        return CoreHttpResponseProvider.responseFail(ex.getErrorCode());
    }

    @ExceptionHandler(AuthenticationException.class)
    public CoreHttpResponseEntity<CoreHttpResponseBodyEntity<Object>> handleAuthenticationException(AuthenticationException ex) {
        log.error("AuthenticationException occurred: {}", ex.getMessage());

        return CoreHttpResponseProvider.responseFail(ex.getErrorCode());
    }

    @ExceptionHandler(ApplicationException.class)
    public CoreHttpResponseEntity<CoreHttpResponseBodyEntity<Object>> handleApplicationException(ApplicationException ex) {
        log.error("ApplicationException occurred: {}", ex.getMessage());

        return CoreHttpResponseProvider.responseFail(ex.getErrorCode());
    }
}
