package top.wuhao.orderservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.apache.coyote.http11.Constants.a;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder( @RequestParam String username,
                               @RequestParam String productId,
                               @RequestParam String orderCreator) {
        String userInfo = restTemplate.getForObject("http://localhost:8081/user?username=" +
                username, String.class);
        String productInfo = restTemplate.getForObject("http://localhost:8083/product?productId=" +
                productId, String.class);

        return "订单细节： " + userInfo + ", 订单创建者： " + orderCreator + ",订单ID： " + productInfo;
    }

    }



