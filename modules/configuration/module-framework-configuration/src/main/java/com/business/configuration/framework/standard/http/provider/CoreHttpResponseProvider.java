package com.business.configuration.framework.standard.http.provider;

import com.business.configuration.framework.standard.enums.BasicResponseType;
import com.business.configuration.framework.standard.http.CoreHttpResponseEntity;
import com.business.configuration.framework.standard.http.body.CoreHttpResponseBodyEntity;

/**
 * <b> CoreHttpResponseBuilder </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-23
 */

public class CoreHttpResponseProvider<T> {

    public static <T> CoreHttpResponseEntity<CoreHttpResponseBodyEntity<T>> responseFail(BasicResponseType errorResponseType) {

        CoreHttpResponseBodyEntity<T> body = CoreHttpResponseBodyEntity.<T>builder()
                .resultCode(errorResponseType.getCode())
                .resultMessage(errorResponseType.getDescription())
                .build();

        return CoreHttpResponseEntity.<CoreHttpResponseBodyEntity<T>>builder()
                .body(body)
                .status(errorResponseType.getHttpStatus())
                .build();
    }
}
