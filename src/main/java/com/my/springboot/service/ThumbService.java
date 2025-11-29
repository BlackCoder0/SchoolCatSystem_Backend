package com.my.springboot.service;

import org.springframework.http.ResponseEntity;

public interface ThumbService {
    ResponseEntity set(String targetType, Long targetId, String attitude);

    ResponseEntity counts(String targetType, Long targetId);
}
