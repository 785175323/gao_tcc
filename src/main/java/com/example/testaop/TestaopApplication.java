package com.example.testaop;

import com.example.testaop.model.Test1;
import com.example.testaop.model.Test2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestaopApplication.class, args);
    }

    @PostMapping("json")
    public Object json(@RequestBody(required = false) @Validated Test1 test, BindingResult bindingResult) {
        boolean b = bindingResult.hasFieldErrors();
        boolean b1 = bindingResult.hasErrors();
        System.out.println(b);
        System.out.println(b1);
        System.out.println(test);
        return "ok";
    }

}

