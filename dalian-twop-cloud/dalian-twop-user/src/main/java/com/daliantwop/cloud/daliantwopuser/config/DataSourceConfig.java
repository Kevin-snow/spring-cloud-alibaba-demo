package com.daliantwop.cloud.daliantwopuser.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin
 * @date 2024/10/15 17:50
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DataSourceConfig {

    @Value("url")
    private String url;

}
