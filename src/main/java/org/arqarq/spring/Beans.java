package org.arqarq.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Import(Beans2.class)
class Beans {
    @Bean("aaa")
    HelloWorld giveBean() {
        return new HelloWorld();
    }

    @Bean
    public HelloWorld2 giveBean2() {
        System.out.println("HelloWorld2 instantiated");
        return new HelloWorld2();
    }

    @PostConstruct
    void init() {
        System.out.println("                                                                        Bean is going through init.");
    }

    @PreDestroy
    void destroy() {
        System.out.println("                                                                        Bean will destroy now.");
    }
}
