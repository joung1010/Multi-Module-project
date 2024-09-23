package com.business.configuration.framework.standard.http.body;

import com.business.configuration.framework.standard.http.header.CoreHttpResponseBodyHeader;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> CoreHttpResponseEntity </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CoreHttpResponseBodyEntity<T> {
    private CoreHttpResponseBodyHeader header;
    private T body;
    private String resultCode;
    private String resultMessage;
}
