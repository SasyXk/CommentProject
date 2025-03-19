
package nl.utwente.soa.sampleBlogApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        System.out.println("Creating RestTemplate bean...");
        return new RestTemplate();
    }
}
