package org.arqarq.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    private final ThreadPoolExecutor threadPoolExecutor;

    App() {
        context.registerShutdownHook();
        context.registerBean(Beans.class, beanDefinition -> beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE));
        context.registerBean("Bean 1", HelloWorld.class, () -> {
            final HelloWorld helloWorld = new HelloWorld();

            helloWorld.setName("1");
            return helloWorld;
        });
        context.refresh();
        context.start();
        threadPoolExecutor = new ThreadPoolExecutor(1, 10, 10 * 60 * 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public static void main(final String[] args) {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("SpringBeans.xml");
        final ClassPathXmlApplicationContext classPathXmlApplicationContext2 =
                new ClassPathXmlApplicationContext("SpringBeans2.xml");
        final ClassPathXmlApplicationContext classPathXmlApplicationContext3 =
                new ClassPathXmlApplicationContext("SpringBeans3.xml");
        final ClassPathXmlApplicationContext classPathXmlApplicationContext4 =
                new ClassPathXmlApplicationContext("SpringBeans4.xml");
        final XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("SpringBeans.xml"));

        classPathXmlApplicationContext.registerShutdownHook();
        HelloWorld helloBean = (HelloWorld) classPathXmlApplicationContext.getBean("helloBean");
        helloBean.setName("4");
        helloBean.printHello();
        helloBean = (HelloWorld) xmlBeanFactory.getBean("helloBean");
        helloBean.printHello();
        new App().start();
        final Run runBean = (Run) classPathXmlApplicationContext2.getBean("runBean");
        runBean.run();
        final Run2 runBean2 = (Run2) classPathXmlApplicationContext3.getBean("runBean2");
        runBean2.run();
        final Run2 runBean4 = (Run2) classPathXmlApplicationContext4.getBean("runBean4");
        runBean4.run2("autowired by constructor");
    }

    void start() {
        HelloWorld helloWorld = (HelloWorld) context.getBean("aaa");
        helloWorld.printHello();
        helloWorld = context.getBean("Bean 1", HelloWorld.class);
        helloWorld.printHello();
        final Run run = new Run(context);
        context.stop();
        context.close();
        new Thread(run).start();
        threadPoolExecutor.execute(run);
        threadPoolExecutor.shutdown();
    }
}
