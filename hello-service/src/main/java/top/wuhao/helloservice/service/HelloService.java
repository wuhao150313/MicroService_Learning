package top.wuhao.helloservice.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class HelloService {
    public String getName(){
        return "Hello service";
    }

    @GetMapping("/sayHello")
    public String sayHello(String name){
        return "hello  " +name;
    }
}
