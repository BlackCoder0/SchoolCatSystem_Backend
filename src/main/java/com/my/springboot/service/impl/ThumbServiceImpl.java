package com.my.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.springboot.empty.Thumb;
import com.my.springboot.mapper.ThumbMapper;
import com.my.springboot.service.ThumbService;
import org.springframework.http.ResponseEntity;
import com.my.springboot.utils.Result.ResponseJson;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThumbServiceImpl extends ServiceImpl<ThumbMapper, Thumb> implements ThumbService {
    @Override
    public ResponseEntity set(String targetType, Long targetId, String attitude) {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LambdaQueryWrapper<Thumb> w = new LambdaQueryWrapper<>();
        w.eq(Thumb::getTargetType, targetType).eq(Thumb::getTargetId, targetId).eq(Thumb::getUsername, userName);
        Thumb one = getOne(w, false);
        if ("none".equalsIgnoreCase(attitude)) {
            if (one != null) {
                remove(w);
            }
            return ResponseJson.success("ok");
        }
        if (one == null) {
            Thumb t = new Thumb();
            t.setTargetType(targetType);
            t.setTargetId(targetId);
            t.setUsername(userName);
            t.setAttitude(attitude);
            save(t);
        } else {
            one.setAttitude(attitude);
            update(one, w);
        }
        return ResponseJson.success("ok");
    }

    @Override
    public ResponseEntity counts(String targetType, Long targetId) {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LambdaQueryWrapper<Thumb> wl = new LambdaQueryWrapper<>();
        wl.eq(Thumb::getTargetType, targetType).eq(Thumb::getTargetId, targetId).eq(Thumb::getAttitude, "like");
        long like = count(wl);
        LambdaQueryWrapper<Thumb> wd = new LambdaQueryWrapper<>();
        wd.eq(Thumb::getTargetType, targetType).eq(Thumb::getTargetId, targetId).eq(Thumb::getAttitude, "dislike");
        long dislike = count(wd);
        LambdaQueryWrapper<Thumb> wm = new LambdaQueryWrapper<>();
        wm.eq(Thumb::getTargetType, targetType).eq(Thumb::getTargetId, targetId).eq(Thumb::getUsername, userName);
        Thumb mine = getOne(wm, false);
        Map<String, Object> map = new HashMap<>();
        map.put("like", like);
        map.put("dislike", dislike);
        map.put("myAttitude", mine == null ? "none" : mine.getAttitude());
        List<Object> data = new java.util.ArrayList<>();
        data.add(map);
        return ResponseJson.success(data);
    }
}
