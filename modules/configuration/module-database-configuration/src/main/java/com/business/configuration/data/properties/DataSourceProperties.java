package com.business.configuration.data.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-05-29
 */

@Getter
@Setter
//@ConfigurationProperties(prefix = "configuration.data.datasource.mysql")
public class DataSourceProperties {
    private String driverClassName;
    private String prefixHost;
    private String host;
    private String username;
    private String password;
}
