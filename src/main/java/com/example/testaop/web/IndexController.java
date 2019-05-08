package com.example.testaop.web;

import com.example.testaop.config.Gao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/14 14:07
 * @Description:
 */
@RestController
public class IndexController {

    @Gao(interface_ = IndexController.class, confirm = "a", cancel = "b")
    @GetMapping
    public void t(String msg,Integer id) {
        if (msg == null) {
            throw new RuntimeException();
        }
        System.out.println(msg);
    }

    public void a(String msg,Integer id) {
        System.out.println(msg + "aaaa");
    }

    public void b(String msg,Integer id) {
        System.out.println(msg + "bbbb");
    }
}
