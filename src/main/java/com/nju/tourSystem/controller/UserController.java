package com.nju.tourSystem.controller;


import com.nju.tourSystem.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("用户信息管理")
@RestController
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @ApiOperation("根据ID获取用户信息")
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        User user = new User();
        user.setEmail("541123989@qq.com");
        return user;
    }


}
