package top.wuhao.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.wuhao.configservice.config.DataBaseProperties;
import top.wuhao.configservice.config.DeepSeekProperties;
import top.wuhao.configservice.config.OssProperties;
import top.wuhao.configservice.config.RedisProperties;

@SpringBootApplication
@EnableConfigurationProperties({DataBaseProperties.class
        ,OssProperties.class
        ,RedisProperties.class
        ,DeepSeekProperties.class}
)
public class ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

}
