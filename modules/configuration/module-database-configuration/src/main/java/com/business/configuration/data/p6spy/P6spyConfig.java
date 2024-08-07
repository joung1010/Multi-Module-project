package com.business.configuration.data.p6spy;

import com.business.configuration.data.p6spy.format.P6spyPrettySqlFormatter;
import com.p6spy.engine.spy.P6SpyOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

/**
 * <b>  </b>
 *
 * @version 0.1.0
 * @since 2024-06-19
 */
@Configuration
public class P6spyConfig {
    @PostConstruct
    public void setLogMessageFormat() {
        P6SpyOptions.getActiveInstance().setLogMessageFormat(P6spyPrettySqlFormatter.class.getName());
        P6SpyOptions.getActiveInstance().setDatabaseDialectDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        P6SpyOptions.getActiveInstance().setDatabaseDialectBooleanFormat("true|false");
    }
}
