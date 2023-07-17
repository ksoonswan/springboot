package me.whiteship.demojpa2.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public ApplicationListener<PostPublishedEvent> postListener(){
        return event -> {
            System.out.println("----------------");
            System.out.println("getPost(): "+event.getPost().getTitle()+" is Published");
            System.out.println("----------------");
        };
    }

}
