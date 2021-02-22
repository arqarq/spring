import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Run implements Runnable {
    private final HelloWorld2 helloWorld2;

    Run(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        helloWorld2 = annotationConfigApplicationContext.getBean(HelloWorld2.class);
        helloWorld2.setName("Arkadiusz3");
    }

    @Override
    public void run() {
        helloWorld2.printHello();
    }
}
