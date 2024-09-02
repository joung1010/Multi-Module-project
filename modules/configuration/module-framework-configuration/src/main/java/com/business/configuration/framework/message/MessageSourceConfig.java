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

        // 패턴에 맞는 메시지 파일들을 모든 모듈에서 찾아 추가
        Resource[] resources = resolver.getResources(RESOURCE_CLASS_PATH);

        for (Resource resource : resources) {
            String uri = resource.getURI().toString();
            // 파일 경로에서 'classpath:' 이후의 부분을 추출
            String baseName = uri.substring(uri.indexOf("/classes/") + "/classes/".length(), uri.lastIndexOf(".properties"));
            basenames.add("classpath:" + baseName);
        }

        messageSource.setBasenames(basenames.toArray(new String[0]));
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600);  // 캐시 기간 설정 (단위: 초)
        messageSource.setDefaultLocale(Locale.ENGLISH);

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
