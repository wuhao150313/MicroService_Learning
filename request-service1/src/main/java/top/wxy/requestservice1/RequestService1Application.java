package top.wxy.requestservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RequestService1Application {
    public static void main(String[] args) {
        SpringApplication.run(RequestService1Application.class, args);
    }
}