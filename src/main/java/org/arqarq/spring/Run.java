package org.arqarq.spring;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

class Run implements Runnable {
    private HelloWorld2 helloWorld2;
    private HelloWorld2 helloWorld22;
    private String name2 = "required";

    Run() {
        System.out.println("---------------------------------- " + name2);
    }

    Run(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        helloWorld2 = annotationConfigApplicationContext.getBean(HelloWorld2.class);
        helloWorld2.setName("3");
    }

    @Required
    public void setName2(String stringName) {
        this.name2 = stringName;
    }

    public void setHelloWorld2(HelloWorld2 helloWorld2) {
        this.helloWorld2 = helloWorld2;
    }

    @Override
    public void run() {
        helloWorld2.printHello();
    }

    @Resource(name = "name2")
    void setHelloWorld22(HelloWorld2 helloWorld22) {
        System.out.println("---------------------------------- " + helloWorld22.name);
        helloWorld22.printHello();
        this.helloWorld22 = helloWorld22;
    }
}
