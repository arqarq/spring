package org.arqarq.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

class RefreshEventHandler implements ApplicationListener<ContextRefreshedEvent> {
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent received");
    }
}
