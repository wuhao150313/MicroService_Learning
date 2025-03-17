package top.wuhao.contentservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.wuhao.contentservice.entity.Share;
import top.wuhao.contentservice.service.ShareService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ContentController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ShareService shareService; // 注入 ShareService

    private final String USER_SERVICE_URL = "http://localhost:8081/user/{id}";

    @GetMapping("/share/{id}")
    @SentinelResource(value="/share/{id}")
    public Map<String, Object> getShareInfo(@PathVariable("id") int id) {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Map<String, Object> result = new HashMap<>();

        // 1️⃣ 查询本地 Share 数据
        Share share = shareService.getById(id);
        if (share == null) {
            result.put("error", "未找到该分享");
            return result;
        }
        result.put("share", share);

        // 2️⃣ 通过 RestTemplate 调用 user-service 获取用户信息
        try {
            Map<String, Object> userInfo = restTemplate.getForObject(USER_SERVICE_URL, Map.class, share.getUserId());
            result.put("author", userInfo);
        } catch (Exception e) {
            result.put("author", "用户信息获取失败");
        }

        return result;
    }
}


