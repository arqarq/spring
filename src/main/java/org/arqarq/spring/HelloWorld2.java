package org.arqarq.spring;

import org.springframework.beans.factory.DisposableBean;

class HelloWorld2 implements DisposableBean {
    public String name = "2";

    public void setName(String stringName) {
        this.name = stringName;
    }

    void printHello() {
        System.out.println("Hello " + name + '!');
    }

    void printHello2(final String text) {
        System.out.println("Hello " + name + ' ' + text + '!');
    }

    public void destroy() {
        System.out.println("  HW2 destroyed");
    }
}
