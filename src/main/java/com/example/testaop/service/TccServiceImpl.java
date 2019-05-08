package com.example.testaop.service;

import org.springframework.stereotype.Service;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/14 09:31
 * @Description:
 */
@Service
public class TccServiceImpl implements TccService {
    @Override
    public void comfirm() {
        System.out.println("tcc成功");
    }

    @Override
    public void cancel() {
        System.out.println("tcc失败");
    }
}
