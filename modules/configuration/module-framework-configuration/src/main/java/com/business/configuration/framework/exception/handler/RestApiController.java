package com.business.configuration.framework.exception.handler;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * <b> RestApiController </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface RestApiController {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
