import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean("aaa")
    HelloWorld giveBean() {
        return new HelloWorld();
    }
}
