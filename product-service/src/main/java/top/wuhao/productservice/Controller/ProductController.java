package top.wuhao.productservice.Controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/product")
    public String createProductOrder(@RequestParam String productId) {
        // 假设通过 productId 获取商品信息

        return productId; // 返回订单编号
    }
}
