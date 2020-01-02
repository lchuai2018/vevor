package com.vevor.core.service.impl;

import com.vevor.core.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/21 9:55
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public void queryTest(String name) {
        System.out.println("参数"+name);
        System.out.println("hello common core!!");
    }
}
