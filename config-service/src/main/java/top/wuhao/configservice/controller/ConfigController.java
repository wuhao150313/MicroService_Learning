package top.wuhao.configservice.controller;



import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wuhao.configservice.config.DataBaseProperties;
import top.wuhao.configservice.config.DeepSeekProperties;
import top.wuhao.configservice.config.OssProperties;
import top.wuhao.configservice.config.RedisProperties;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Resource
    private RedisProperties redisProperties;
    @Resource
    private OssProperties ossProperties;
    @Resource
    private DataBaseProperties dataBaseProperties;
    @Resource
    private DeepSeekProperties deepSeekProperties;

    @GetMapping("/test")
    public String get() {
        return "Redis配置：地址：" + redisProperties.getHost() +
                " 端点：" + redisProperties.getPort() +
                " 密码：" + redisProperties.getPassword() + "<br><br>" +

                "Oss配置：地址：" + ossProperties.getEndpoint() +
                " Id:" + ossProperties.getAccessKeyId() +
                " 密钥：" + ossProperties.getAccessKeySecret() +
                " 容器名称：" + ossProperties.getBucketName() + "<br><br>" +

                "数据库配置：url：" + dataBaseProperties.getUrl() +
                " 用户名：" + dataBaseProperties.getUsername() +
                " 密码：" + dataBaseProperties.getPassword() +
                " 驱动类名：" + dataBaseProperties.getDriverClassName() + "<br><br>" +

                "DeepSeek配置：api密钥：" + deepSeekProperties.getApikey();
    }
}
