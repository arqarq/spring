package org.arqarq.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Beans3 {
    @Bean
    public CustomEventPublisher customEventPublisher() {
        return new CustomEventPublisher();
    }

    @Bean
    public CustomEventHandler<CustomEventPublisher> giveBean8() {
        return new CustomEventHandler<>();
    }
}
