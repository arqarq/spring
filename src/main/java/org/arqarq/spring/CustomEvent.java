package org.arqarq.spring;

import org.springframework.context.ApplicationEvent;

class CustomEvent<T> extends ApplicationEvent {
    public CustomEvent(T source) {
        super(source);
    }

    @Override
    public String toString() {
        return "Custom Event received";
    }

    T getSourceObj() {
        return (T) super.getSource();
    }
}
