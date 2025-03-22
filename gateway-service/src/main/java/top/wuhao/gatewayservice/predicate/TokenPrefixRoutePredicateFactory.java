package top.wuhao.gatewayservice.predicate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class TokenPrefixRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenPrefixRoutePredicateFactory.Config> {

    public static final String PREFIX = "prefix";

    public TokenPrefixRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(PREFIX);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                String token = exchange.getRequest().getQueryParams().getFirst("token");
                return StringUtils.isNotBlank(token) && token.startsWith(config.getPrefix());
            }

            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public String toString() {
                return String.format("Token starts with: %s", config.getPrefix());
            }
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        @NotNull
        private String prefix;
    }
}
