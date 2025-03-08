package top.wuhao.configservice.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Setter
@Getter
@Data
@Component
@ConfigurationProperties(prefix = "wuhao.api")
public class DeepSeekProperties {
    private String apikey;
}
