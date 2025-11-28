package com.my.springboot.service;

import com.my.springboot.empty.Cat;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

public interface CatService extends IService<Cat> {

    ResponseEntity addData(Cat cat);

    ResponseEntity getAllData();

    ResponseEntity updateDataById(Cat cat);

    ResponseEntity getDataById(Long id);

    ResponseEntity delDataById(Long id);

    ResponseEntity getDataLikeKey(String key);
}
