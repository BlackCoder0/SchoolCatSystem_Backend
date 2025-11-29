package com.my.springboot.controller;

import com.my.springboot.service.ThumbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "ThumbController")
@RestController
public class ThumbController {
    @Autowired
    private ThumbService thumbService;

    @ApiOperation("设置点赞点踩")
    @PostMapping("/thumb/set")
    public ResponseEntity set(@RequestParam("targetType") String targetType,
                              @RequestParam("targetId") Long targetId,
                              @RequestParam("attitude") String attitude) {
        return thumbService.set(targetType, targetId, attitude);
    }

    @ApiOperation("获取点赞点踩数量与我的态度")
    @PostMapping("/thumb/counts")
    public ResponseEntity counts(@RequestParam("targetType") String targetType,
                                 @RequestParam("targetId") Long targetId) {
        return thumbService.counts(targetType, targetId);
    }
}
