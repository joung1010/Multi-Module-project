package com.business.configuration.framework.message;

import com.business.configuration.framework.utils.MessageToolkits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <b> MessageSourceConfig </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
@Slf4j
@Configuration
public class MessageSourceConfig {

    private static final String RESOURCE_CLASS_PATH = "classpath*:messages*.properties";

    @Bean
    public MessageSource messageSource() throws IOException {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        List<String> basenames = new ArrayList<>();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // 모든 모듈의 messages*.properties 파일 탐색
        Resource[] resources = resolver.getResources(RESOURCE_CLASS_PATH);

        for (Resource resource : resources) {
            String uri = resource.getURI().toString();
            log.info("===== Loaded message file: {}", uri);

            // 파일명에서 확장자와 경로를 제외한 부분만 추출 (messages_ko, messages_en 등)
            String baseName = uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('.'));

            // classpath 경로로 추가 (확장자 제외)
            basenames.add("classpath:" + baseName);
        }

        // 모든 베이스네임들을 설정 (확장자가 없어야 한다)
        messageSource.setBasenames(basenames.toArray(new String[0]));
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600);  // 캐시 비활성화
        messageSource.setDefaultLocale(Locale.KOREA);

        return messageSource;
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource);
        MessageToolkits.setOnceMessageSourceAccessor(messageSourceAccessor);

        return messageSourceAccessor;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource)  {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
