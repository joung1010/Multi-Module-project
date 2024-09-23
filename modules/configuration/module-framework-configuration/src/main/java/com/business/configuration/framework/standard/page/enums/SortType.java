package com.business.configuration.framework.standard.page.enums;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

/**
 * <b> SortType </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-23
 */
public enum SortType {
    ASC,
    DESC;

    public static String findAndValidSortType(final String sort) {
        return Arrays.stream(SortType.values())
                .filter(sortType -> sortType.name().equalsIgnoreCase(sort))
                .findFirst()
                .map(Enum::name)
                .orElseThrow(() -> CoreExceptionHandler.handleBadRequestException(BasicErrorCode.INVALID_INPUT_VALUE));
    }
}
