package com.atguigu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        /**
         * 日志的级别由低到高 trace<debug<info<warn<error
         * 可以调整输出的日志级别，日志就会在这个级别以后的高级别生效
         * springboot默认给我们的日志级别是info
         *
         * 日志框架还可以指定配置，具体方式为给类路径下放上自己的配置文件即可，springboot就不会再使用它默认配置的了
         * 当然配置文件的命名有规定的，具体细节在此不多说，查百度
         *
         *如若命名为logback.xml，那么直接就会被日志框架识别
         * 当命名为logback-spring.xml：日志框架就不能够直接加载日志的配置项，由springboot来解析日志的配置
         *这样的话可以用到springboot的高级profile功能
         */
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

}
