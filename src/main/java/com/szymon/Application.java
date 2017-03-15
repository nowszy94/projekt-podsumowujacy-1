package com.szymon;

import com.szymon.model.Link;
import com.szymon.model.User;
import com.szymon.repository.LinkRepository;
import com.szymon.repository.UserRepository;
import com.szymon.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkRepository linkRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void initDatabase() {
        User user = new User();
        user.setFirstName("Szymon");
        user.setLastName("Nowak");

        User user2 = new User();
        user2.setFirstName("Jan");
        user2.setLastName("Kowalski");

        User user3 = new User();
        user3.setFirstName("Andrzej");
        user3.setLastName("Duda");

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);

        linkRepository.save(new Link("About", "/home"));
        linkRepository.save(new Link("Service", "/home"));
        linkRepository.save(new Link("Contact", "/home"));
    }
}
