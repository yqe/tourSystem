package com.nju.tourSystem.controller;


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
public class userController {
    private static final Logger logger= LoggerFactory.getLogger(userController.class);

    @ApiOperation("用户信息")
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable int id) {
        logger.info("开始查询某个用户信息");
        return "success";
    }


}
