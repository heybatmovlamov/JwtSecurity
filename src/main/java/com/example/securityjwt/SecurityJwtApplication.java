package com.example.securityjwt;

import com.example.securityjwt.entity.User;
import com.example.securityjwt.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@SpringBootApplication
public class SecurityJwtApplication {
    private final  UserRepository userRepository;
    @PostConstruct
    public void createUser(){
        List<User>  users = Stream.of(
                new User(1 ,"Heybat","Movlamov" , "heybatmovlamov@gmail.com"),
                new User(2 ,"Heybat2","Movlamov2" , "heybatmovlamov2@gmail.com"),
                new User(3 ,"Heybat3","Movlamov3" , "heybatmovlamov3@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

}
