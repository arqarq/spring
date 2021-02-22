package org.arqarq.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

class HelloWorld implements DisposableBean, InitializingBean {
    private String name;

    public void setName(String stringName) {
        this.name = stringName;
    }

    void printHello() {
        System.out.println("Hello " + name + '!');
    }

    void init() {
        System.out.println(" HW initiated");
    }

    @Override
    public void destroy() {
        System.out.println("  HW destroyed via interface");
    }

    void destroy2() {
        System.out.println(" HW destroyed");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("  HW initiated via interface");
    }
}
