package com.my.springboot.service;

import com.my.springboot.empty.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

public interface PostService extends IService<Post> {

    ResponseEntity addData(Post post);

    ResponseEntity getAllData();

    ResponseEntity updateDataById(Post post);

    ResponseEntity getDataById(Long id);

    ResponseEntity delDataById(Long id);

    ResponseEntity getDataLikeKey(String key);

    ResponseEntity getMyData();
}
