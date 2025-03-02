package top.wuhao.contentservice.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.wuhao.contentservice.dto.UserDTO;


@FeignClient(name = "user-service", url = "http://localhost:8081")  // 这里的URL可以改为具体的服务地址
public interface UserFeignClient {

    // 调用 user-service 的 /user/{id} 端点，返回 UserDTO
    @GetMapping("/user/{id}")
    UserDTO getUserById(@PathVariable("id") int id);
}


