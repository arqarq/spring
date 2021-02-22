package org.arqarq.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
class Beans2 {
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public InitHelloWorld giveBean3() {
        return new InitHelloWorld();
    }

    @Bean
    public StartEventHandler giveBean4() {
        return new StartEventHandler();
    }

    @Bean
    public StopEventHandler giveBean5() {
        return new StopEventHandler();
    }

    @Bean
    public RefreshEventHandler giveBean6() {
        return new RefreshEventHandler();
    }

    @Bean
    public ClosedEventHandler giveBean7() {
        return new ClosedEventHandler();
    }

    @PostConstruct
    void init() {
        System.out.println("                                                                        Beans2 is going through init.");
    }

    @PreDestroy
    void destroy() {
        System.out.println("                                                                        Beans2 will destroy now.");
    }
}
