import org.springframework.context.annotation.Bean;

class Beans {
    @Bean("aaa")
    HelloWorld giveBean() {
        return new HelloWorld();
    }

    @Bean
    public HelloWorld2 giveBean2() {
        System.out.println("HelloWorld2 instantiated");
        return new HelloWorld2();
    }
}
