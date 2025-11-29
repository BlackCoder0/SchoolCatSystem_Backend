package com.my.springboot.service;

import com.my.springboot.empty.Recover;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;


public interface RecoverService extends IService<Recover> {

    ResponseEntity addRecoverData(Recover recover);

    ResponseEntity getAllRecoverData(Long pid);

    ResponseEntity delRecoverById(Long id);

    ResponseEntity getMyRecoverData();
}
