package com.business.configuration.framework.exception.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <b> BasicErrorMessageContents </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BasicErrorMessageContents {

    public static final String REQUIRED_PARAMETER_MISSING = "Required parameter is missing";
}
