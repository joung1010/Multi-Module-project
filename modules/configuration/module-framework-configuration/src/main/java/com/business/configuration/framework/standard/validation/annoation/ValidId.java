package com.business.configuration.framework.standard.validation.annoation;

import com.business.configuration.framework.standard.validation.IdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * <b> ValidId </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-04
 */

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidId {

    String message() default "Invalid ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
