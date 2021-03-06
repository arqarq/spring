package org.arqarq.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

class CustomEventPublisher implements ApplicationEventPublisherAware {
    private final int id = 1111;
    private ApplicationEventPublisher publisher;

    int getId() {
        return id;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    void publish() {
        publisher.publishEvent(new CustomEvent<>(this));
    }
}
