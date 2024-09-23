package com.business.configuration.framework.standard.http.header;

import com.business.configuration.framework.standard.page.CorePageInfo;
import com.business.configuration.framework.utils.UniqueIdGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <b> CoreHttpResponseBodyHeader </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CoreHttpResponseBodyHeader extends CorePageInfo{
    @Builder.Default
    private String requestId = UniqueIdGenerator.generateUuidNoDash();

}
