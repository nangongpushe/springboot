package com.atguigu.actutor.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        //自定义的检查方法
        //Health.up().build()表示健康状态
        return Health.down().withDetail("msg","服务异常").build();
    }
}
