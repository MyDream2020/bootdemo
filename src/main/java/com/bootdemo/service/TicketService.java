package com.bootdemo.service;

import com.bootdemo.dao.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ASUS
 * @Date: 2020/5/8 21:49
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TicketService {
    private TicketMapper mapper;

    @Autowired
    public TicketService(TicketMapper mapper) {
        this.mapper = mapper;
    }



}
