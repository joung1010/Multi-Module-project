package com.business.configuration.framework.utils;

import com.business.configuration.framework.standard.enums.CommonCodeType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

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

    public static String getMessage(CommonCodeType code, String... replaceMessage) {
        return getMessage(code.getCode(), replaceMessage);
    }

    public static String getMessage(CommonCodeType code) {
        return getMessage(code.getCode());
    }


    public static String getMessage(String name, String... replaceMessage) {
        try {
            // 명시적으로 Locale 설정 (테스트 시 변경 가능)
            Locale locale = LocaleContextHolder.getLocale();
            log.info("Current locale: {}", locale);
            return accessor.getMessage(name, replaceMessage, locale);
        } catch (Exception e) {
            log.error("Error retrieving message for key {}: {}", name, e.getMessage(), e);
            return null;
        }
    }

}
