package com.business.configuration.framework.standard.http.provider;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.standard.enums.BasicResponseType;
import com.business.configuration.framework.standard.http.CoreHttpResponseEntity;
import com.business.configuration.framework.standard.http.body.CoreHttpResponseBodyEntity;
import com.business.configuration.framework.utils.MessageToolkits;

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

    public static <T> CoreHttpResponseBodyEntity<T> responseSuccess(T body) {

        return CoreHttpResponseBodyEntity.<T>builder()
                .body(body)
                .resultCode(BasicErrorCode.SUCCESS.getCode())
                .resultMessage(MessageToolkits.getMessage(BasicErrorCode.SUCCESS.getCode()))
                .build();

    }


}
