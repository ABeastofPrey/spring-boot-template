package com.kuka.springtemplate.config;

// import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Data
@Component
// @ConfigurationProperties(prefix = "spring.datasource")
public class SpringDatasourceProp {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username = "root";
    @Value("${spring.datasource.password}")
    private String password;
    // private String driverClassName = "";
}
