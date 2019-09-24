package com.cimc.controller;

import com.cimc.entity.BaseResult;
import com.cimc.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author chenz
 */
@RestController
@RequestMapping("/")
@Api(tags = "用户操作API", protocols = "http")
public class UserController {

    @ApiOperation(
            value = "用户列表",
            notes = "完整用户列表",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = List.class
    )
    @GetMapping("/users")
    public List<User> list(@RequestParam(value = "page", defaultValue = "1") String page, @RequestParam(value = "size", defaultValue = "10") String size) {
        System.out.println("page: " + page);
        System.out.println("size: " + size);
        User user = new User();
        user.setId(1L);
        user.setName("James");
        user.setAge(35);
        user.setBirthday(new Date());

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Kobe");
        user2.setAge(40);
        user2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        return userList;
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("James");
        user.setAge(35);
        user.setBirthday(new Date());
        return user;
    }

    @ApiOperation(value = "添加用户", notes = "根据参数新建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", paramType = "body"),
            @ApiImplicitParam(name = "birthday", value = "生日", required = true, dataType = "date", paramType = "body")
    })
    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return user;
    }

    @ApiOperation(value = "修改用户信息", notes = "根据参数修改用户信息")
    @PutMapping("/user")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 102, message = "禁止访问"),
            @ApiResponse(code = 103, message = "请求路径不存在"),
            @ApiResponse(code = 200, message = "服务器内部错误"),
    })
    public User update(@RequestBody User user) {
        return user;
    }

    @PatchMapping("/user/name")
    public BaseResult<User> patch(User user) {
        return BaseResult.successWithData(user);
    }

    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

}