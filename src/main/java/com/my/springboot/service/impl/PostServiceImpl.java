package com.my.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.my.springboot.empty.Post;
import com.my.springboot.service.PostService;
import com.my.springboot.mapper.PostMapper;
import com.my.springboot.utils.Result.ResponseJson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {

    @Override
    public ResponseEntity addData(Post post) {
        if (save(post)) {
            return ResponseJson.success("新增失败");
        } else {
            return ResponseJson.fail(400, "新增失败");
        }
    }

    @Override
    public ResponseEntity getAllData() {
        LambdaQueryWrapper<Post> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Post> list = list(lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("datalist", list);
        List<Object> dataList = new ArrayList<>();
        dataList.add(map);
        return ResponseJson.success(dataList);
    }

    @Override
    public ResponseEntity updateDataById(Post post) {
        LambdaUpdateWrapper<Post> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Post::getId, post.getId());
        lambdaUpdateWrapper.set(Post::getName, post.getName());
        lambdaUpdateWrapper.set(Post::getContent, post.getContent());
        lambdaUpdateWrapper.set(Post::getHuati, post.getHuati());
        lambdaUpdateWrapper.set(Post::getTime, post.getTime());
        if (update(lambdaUpdateWrapper)) {
            return ResponseJson.success("修改成功");
        }
        return ResponseJson.fail(400, "修改失败");
    }

    @Override
    public ResponseEntity getDataById(Long id) {
        LambdaQueryWrapper<Post> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Post::getId, id);
        List<Post> list = list(lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("datalist", list);
        List<Object> dataList = new ArrayList<>();
        dataList.add(map);
        return ResponseJson.success(dataList);
    }

    @Override
    public ResponseEntity delDataById(Long id) {
        if (getBaseMapper().deleteById(id) > 0) {
            return ResponseJson.success("删除成功");
        } else {
            return ResponseJson.fail(400, "删除失败");
        }
    }

    @Override
    public ResponseEntity getDataLikeKey(String key) {
        LambdaQueryWrapper<Post> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Post::getHuati, key);
        List<Post> list = list(lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("datalist", list);
        List<Object> dataList = new ArrayList<>();
        dataList.add(map);
        return ResponseJson.success(dataList);
    }

    @Override
    public ResponseEntity getMyData() {
        LambdaQueryWrapper<Post> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String userName = (String) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        lambdaQueryWrapper.eq(Post::getName, userName);
        List<Post> list = list(lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("datalist", list);
        List<Object> dataList = new ArrayList<>();
        dataList.add(map);
        return ResponseJson.success(dataList);
    }
}
