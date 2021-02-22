package org.arqarq.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

class StopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("ContextStoppedEvent received");
    }
}
