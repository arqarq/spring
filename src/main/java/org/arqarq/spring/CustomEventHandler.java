package org.arqarq.spring;

import org.springframework.context.ApplicationListener;

class CustomEventHandler<T extends CustomEventPublisher> implements ApplicationListener<CustomEvent<T>> {
    public void onApplicationEvent(CustomEvent<T> event) {
        System.out.println(event.getSourceObj().getId());
        System.out.println(event.toString());
    }
}
