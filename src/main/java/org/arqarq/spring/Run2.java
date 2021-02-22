package org.arqarq.spring;

class Run2 {
    private final HelloWorld2 helloWorld2;

    Run2(HelloWorld2 helloWorld2) {
        this.helloWorld2 = helloWorld2;
    }

    Run2(HelloWorld2 helloWorld2, String text) {
        this.helloWorld2 = helloWorld2;
        System.out.println(text);
    }

    void run() {
        helloWorld2.printHello();
    }

    void run2(final String text) {
        helloWorld2.printHello2(text);
    }
}
