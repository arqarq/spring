package org.arqarq.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

class StartEventHandler implements ApplicationListener<ContextStartedEvent> {
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("ContextStartedEvent received");
    }
}
