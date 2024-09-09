package com.business.configuration.framework.exception.handler;

import com.business.configuration.framework.exception.*;
import com.business.configuration.framework.standard.enums.BasicResponseType;
import com.business.configuration.framework.utils.MessageToolkits;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <b> CoreExceptionHandler </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoreExceptionHandler {

    public static <E extends Enum<E> & BasicResponseType> BusinessException handleBusinessException(E enumClass
            , String... replaceMessage) {

        String message = MessageToolkits.getMessage(enumClass, replaceMessage);
        return new BusinessException(enumClass, message);
    }

    public static <E extends Enum<E> & BasicResponseType> BusinessException handleBusinessException(E enumClass) {

        String message = MessageToolkits.getMessage(enumClass);
        return new BusinessException(enumClass, message);
    }

    public static <E extends Enum<E> & BasicResponseType> DatabaseException handleDatabaseException(E enumClass
            , String... replaceMessage) {

        String message = MessageToolkits.getMessage(enumClass, replaceMessage);
        return new DatabaseException(message);
    }

    public static <E extends Enum<E> & BasicResponseType> DatabaseException handleDatabaseException(E enumClass) {

        String message = MessageToolkits.getMessage(enumClass);
        return new DatabaseException(message);
    }

    public static <E extends Enum<E> & BasicResponseType> AuthorizationException handleAuthorizationException(E enumClass
            , String... replaceMessage) {

        String message = MessageToolkits.getMessage(enumClass, replaceMessage);
        return new AuthorizationException(message);
    }

    public static <E extends Enum<E> & BasicResponseType> AuthorizationException handleAuthorizationException(E enumClass) {

        String message = MessageToolkits.getMessage(enumClass);
        return new AuthorizationException(message);
    }

    public static <E extends Enum<E> & BasicResponseType> AuthenticationException handleAuthenticationException(E enumClass
            , String... replaceMessage) {

        String message = MessageToolkits.getMessage(enumClass, replaceMessage);
        return new AuthenticationException(message);
    }

    public static <E extends Enum<E> & BasicResponseType> AuthenticationException handleAuthenticationException(E enumClass) {

        String message = MessageToolkits.getMessage(enumClass);
        return new AuthenticationException(message);
    }

    public static ApplicationException handleUnknownException(Throwable exception) {
        log.error("Unknown exception occurred: {}", exception.getMessage(), exception);
        return new ApplicationException(exception);
    }
    public static <E extends Enum<E> & BasicResponseType> ApplicationException handleUnknownException(E enumClass
            , String... replaceMessage) {

        String message = MessageToolkits.getMessage(enumClass, replaceMessage);
        return new ApplicationException(enumClass,message);
    }
    public static <E extends Enum<E> & BasicResponseType> ApplicationException handleUnknownException(E enumClass) {

        String message = MessageToolkits.getMessage(enumClass);
        return new ApplicationException(enumClass,message);
    }
}
