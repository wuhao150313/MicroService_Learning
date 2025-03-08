package org.example.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wuhao")
@Data
public class WuhaoProperties {
    private String username;
    private String job;
    private boolean serviceFlag;
}
