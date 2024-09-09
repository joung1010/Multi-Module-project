package com.business.configuration.framework.utils;

import com.business.configuration.framework.standard.enums.CommonCodeType;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * <b> MessageToolkits </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageToolkits {
    private static MessageSourceAccessor accessor;

    public static synchronized void setOnceMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        if (ObjectToolkits.isEmpty(accessor)) {
            accessor = messageSourceAccessor;
        }
    }

    public static String getMessage(CommonCodeType code, String ... replaceMessage) {
        return getMessage(code.getCode(), replaceMessage);
    }

    public static String getMessage(CommonCodeType code) {
        return getMessage(code.getCode());
    }


    public static String getMessage(String name, String... replaceMessage) {
        try {
            return accessor.getMessage(name, replaceMessage);
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
