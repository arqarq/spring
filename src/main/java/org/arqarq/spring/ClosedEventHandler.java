package org.arqarq.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

class ClosedEventHandler implements ApplicationListener<ContextClosedEvent> {
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("ContextClosedEvent received");
    }
}
