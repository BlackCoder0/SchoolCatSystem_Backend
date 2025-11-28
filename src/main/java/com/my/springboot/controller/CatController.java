package com.my.springboot.controller;

import com.my.springboot.empty.Cat;
import com.my.springboot.service.impl.CatServiceImpl;
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
public class CatController {

    @Autowired
    CatServiceImpl catService;

    @ApiOperation("添加一条数据")
    @PostMapping("/addData")
    public ResponseEntity addData(@RequestBody Cat cat) {
        return catService.addData(cat);
    }

    @ApiOperation("获取所有数据")
    @PostMapping("/getAllData")
    public ResponseEntity getAllData() {
        return catService.getAllData();
    }

    @ApiOperation("修改数据")
    @PostMapping("/updateDataById")
    public ResponseEntity updateDataById(@RequestBody Cat cat) {
        return catService.updateDataById(cat);
    }

    @ApiOperation("根据ID查数据")
    @PostMapping("/getDataById")
    public ResponseEntity getDataById(@RequestParam("Id") Long Id) {
        return catService.getDataById(Id);
    }

    @ApiOperation("根据ID删数据")
    @PostMapping("/delDataById")
    public ResponseEntity delDataById(@RequestParam("Id") Long Id) {
        return catService.delDataById(Id);
    }

    @ApiOperation("模糊查询")
    @PostMapping("/getDataLikeKey")
    public ResponseEntity getDataLikeKey(@RequestParam("key") String key) {
        return catService.getDataLikeKey(key);
    }

}
