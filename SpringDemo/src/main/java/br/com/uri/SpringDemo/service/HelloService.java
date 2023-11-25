package br.com.uri.SpringDemo.service;

import br.com.uri.SpringDemo.entities.HelloEntity;
import br.com.uri.SpringDemo.repositories.HelloRepository;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final HelloRepository helloRepository;


    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public String sayHello() {
        HelloEntity hello = new HelloEntity();
        hello.setId(1L);
        hello.setMessage("Hello World");
        helloRepository.save(hello);
        return "Hello World";
    }

}
