package com.business.configuration.framework.standard.validation;


import com.business.configuration.framework.standard.validation.annoation.ValidId;
import com.business.configuration.framework.utils.StringToolkits;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


/**
 * <b> IdValidator </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-04
 */
public class IdValidator implements ConstraintValidator<ValidId, String> {

    @Override
    public boolean isValid(String s
            , ConstraintValidatorContext constraintValidatorContext) {

        String id = s.trim();
        return StringToolkits.isNoneBlank(id);
    }
}
