package com.my.springboot.controller;

import com.my.springboot.empty.Post;
import com.my.springboot.service.impl.PostServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "数据类接口")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @ApiOperation("添加一条数据")
    @PostMapping("/addData")
    public ResponseEntity addData(@RequestBody Post post) {
        return postService.addData(post);
    }

    @ApiOperation("获取所有数据")
    @PostMapping("/getAllData")
    public ResponseEntity getAllData() {
        return postService.getAllData();
    }

    @ApiOperation("修改数据")
    @PostMapping("/updateDataById")
    public ResponseEntity updateDataById(@RequestBody Post post) {
        return postService.updateDataById(post);
    }

    @ApiOperation("根据ID查数据")
    @PostMapping("/getDataById")
    public ResponseEntity getDataById(@RequestParam("Id") Long Id) {
        return postService.getDataById(Id);
    }

    @ApiOperation("根据ID删数据")
    @PostMapping("/delDataById")
    public ResponseEntity delDataById(@RequestParam("Id") Long Id) {
        return postService.delDataById(Id);
    }

    @ApiOperation("模糊查询")
    @PostMapping("/getDataLikeKey")
    public ResponseEntity getDataLikeKey(@RequestParam("key") String key) {
        return postService.getDataLikeKey(key);
    }

    @ApiOperation("获取自己的发言")
    @PostMapping("/getMyData")
    public ResponseEntity getMyData() {
        return postService.getMyData();
    }
}
