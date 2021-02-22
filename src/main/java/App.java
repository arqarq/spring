import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    private final ThreadPoolExecutor threadPoolExecutor;

    App() {
        context.registerBean("Bean 1", HelloWorld.class, () -> {
            final HelloWorld helloWorld = new HelloWorld();

            helloWorld.setName("Arek");
            return helloWorld;
        });
        context.registerBean(Beans.class);
        context.refresh();
        context.registerShutdownHook();
        threadPoolExecutor = new ThreadPoolExecutor(1, 10, 10 * 60 * 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
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
        final Run run = new Run(context);
        new Thread(run).start();
        threadPoolExecutor.execute(run);
        threadPoolExecutor.shutdown();
    }
}
