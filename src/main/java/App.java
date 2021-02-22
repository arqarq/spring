import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    App() {
        this.context.registerBean("Bean 1", HelloWorld.class, () -> {
            final HelloWorld helloWorld = new HelloWorld();
            helloWorld.setName("Arek");
            return helloWorld;
        });
        this.context.registerBean(Beans.class);
        this.context.refresh();
    }

    public static void main(final String[] args) {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("SpringBeans.xml");

        final HelloWorld helloBean = classPathXmlApplicationContext.getBean("helloBean", HelloWorld.class);
        helloBean.printHello();
        new App().start();
    }

    void start() {
        HelloWorld helloWorld = context.getBean("Bean 1", HelloWorld.class);
        helloWorld.printHello();
        helloWorld = (HelloWorld) context.getBean("aaa");
        helloWorld.printHello();
        context.registerShutdownHook();
    }
}
