package top.wuhao.configservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/deepseek")
@RefreshScope
public class AiController {
    @Value("${wuhao.api.api-key}")
    private String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // 使用动态路径，例如：/deepseek/今天天气怎么样
    @GetMapping("/{question}")
    public Mono<String> askDeepSeek(@PathVariable String question) {
        WebClient webClient = WebClient.create("https://api.deepseek.com");

        // 构建请求体
        String requestBody = """
            {
                "model": "deepseek-chat",
                "messages": [
                    {
                        "role": "user",
                        "content": "%s"
                    }
                ]
            }
            """.formatted(question);

        return webClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .map(jsonResponse -> {
                    try {
                        JsonNode rootNode = objectMapper.readTree(jsonResponse);
                        return rootNode.path("choices")
                                .path(0)
                                .path("message")
                                .path("content")
                                .asText();
                    } catch (Exception e) {
                        return "Failed to parse DeepSeek response: " + e.getMessage();
                    }
                });
    }
}
