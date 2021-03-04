package com.kkdz.dblock.web;

import java.util.UUID;

import com.kkdz.dblock.domain.LockTest;
import com.kkdz.dblock.mapper.LockTestMapper;
import com.kkdz.dblock.service.ChineseName;
import com.kkdz.dblock.service.LockTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AController {

    @Autowired
    private LockTestMapper ltMapper;

    @Autowired
    private LockTestService ltService;

    @GetMapping(value="/test")
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        LockTest entity = new LockTest();
        entity.setBizId(UUID.randomUUID().toString());
        entity.setAge((int)(Math.random() * 100));
        entity.setName(ChineseName.getName());
        entity.setSex((Math.random() * 100) % 2 == 0 ? "Male" : "Female");
        ltMapper.insert(entity);
        ltService.update(entity);
    }
    
    
}