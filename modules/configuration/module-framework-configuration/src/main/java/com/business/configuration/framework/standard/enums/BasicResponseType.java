package com.business.configuration.framework.standard.enums;

import org.springframework.http.HttpStatus;

/**
 * <b> BasicResponseType </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
public interface BasicResponseType extends CommonCodeType{
    HttpStatus getHttpStatus();
}
