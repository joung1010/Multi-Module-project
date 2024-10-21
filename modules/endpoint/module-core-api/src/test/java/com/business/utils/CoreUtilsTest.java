package com.business.utils;

import com.business.configuration.framework.utils.MessageToolkits;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <b> CoreUtilsTest </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-14
 */

@Slf4j
@ActiveProfiles("local")
@SpringBootTest
public class CoreUtilsTest {

    @BeforeEach
    public void setUp() {
        LocaleContextHolder.setLocale(Locale.KOREA);
    }


    @Test
    public void testKoLocaleMessage() {
        LocaleContextHolder.setLocale(Locale.KOREA);  // 한국어 로케일 설정
        log.info("현재 로케일: {}", LocaleContextHolder.getLocale());  // 로케일 확인을 위한 로그 추가

        // MessageToolkits가 사용하는 MessageSourceAccessor에서 현재 로케일 설정을 명확하게 확인
        String message = MessageToolkits.getMessage("COMMON-014");
        log.info("message: {}", message);

        assertEquals("서버에서 문제가 발생했습니다.", message);  // 기대 값
    }

    @Test
    public void testEnLocaleMessage() {
        LocaleContextHolder.setLocale(Locale.ENGLISH);  // 영어 로케일 설정
        String message = MessageToolkits.getMessage("COMMON-014");
        assertEquals("An error occurred on the server.", message);  // 기대 값
    }
}
