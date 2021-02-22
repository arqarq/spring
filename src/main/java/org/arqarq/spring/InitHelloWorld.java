package org.arqarq.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

class InitHelloWorld implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("   xxxx xxxx xxxx xxxx xxxx xxxx BeforeInitialization: " + beanName);
        return bean; // you can return any other object as well
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("   xxxx xxxx xxxx xxxx xxxx xxxx AfterInitialization: " + beanName);
        return bean; // you can return any other object as well
    }

    void init() {
        System.out.println("// initialization logic");
    }

    void cleanup() {
        System.out.println("// destruction logic");
    }
}
