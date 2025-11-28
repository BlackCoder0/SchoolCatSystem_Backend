package com.my.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.my.springboot.empty.Cat;
import com.my.springboot.service.CatService;
import com.my.springboot.mapper.CatMapper;
import com.my.springboot.utils.Result.ResponseJson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat>
        implements CatService {

    @Override
    public ResponseEntity addData(Cat cat) {
        if (save(cat)) {
            return ResponseJson.success("新增失败");
        } else {
            return ResponseJson.fail(400, "新增失败");
        }
    }

    @Override
    public ResponseEntity getAllData() {
        LambdaQueryWrapper<Cat> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Cat> list = list(lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("datalist", list);
        List<Object> dataList = new ArrayList<>();
        dataList.add(map);
        return ResponseJson.success(dataList);
    }

    @Override
    public ResponseEntity updateDataById(Cat cat) {
        LambdaUpdateWrapper<Cat> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Cat::getId, cat.getId());
        lambdaUpdateWrapper.set(Cat::getName, cat.getName());
        lambdaUpdateWrapper.set(Cat::getContent, cat.getContent());
        lambdaUpdateWrapper.set(Cat::getHuati, cat.getHuati());
        lambdaUpdateWrapper.set(Cat::getTime, cat.getTime());
        if (update(lambdaUpdateWrapper)) {
            return ResponseJson.success("修改成功");
        }
        return ResponseJson.fail(400, "修改失败");
    }

    @Override
    public ResponseEntity getDataById(Long id) {
        LambdaQueryWrapper<Cat> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Cat::getId, id);
        List<Cat> list = list(lambdaQueryWrapper);
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
        LambdaQueryWrapper<Cat> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Cat::getHuati, key);
        List<Cat> list = list(lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("datalist", list);
        List<Object> dataList = new ArrayList<>();
        dataList.add(map);
        return ResponseJson.success(dataList);
    }
}
