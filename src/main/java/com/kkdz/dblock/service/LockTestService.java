package com.kkdz.dblock.service;

import com.kkdz.dblock.domain.LockTest;
import com.kkdz.dblock.mapper.LockTestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LockTestService {


    @Autowired
    LockTestMapper lTestMapper;


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(LockTest entity){
        entity.setAge((int)(Math.random() * 100));
        lTestMapper.update(entity);
    }
    
}