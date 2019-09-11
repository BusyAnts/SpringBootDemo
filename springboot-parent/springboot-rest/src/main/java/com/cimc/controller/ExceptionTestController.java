package com.cimc.controller;

import com.cimc.exp.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常测试
 *
 * @author chenz
 * @create 2019-09-11 10:12
 */
@RestController
@RequestMapping("exp")
public class ExceptionTestController {

    @GetMapping("/test1/{param}")
    public Integer test1(@PathVariable("param") Integer param) {
        int res = 100 / param;
        return res;
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("Json解析错误");
    }
}
