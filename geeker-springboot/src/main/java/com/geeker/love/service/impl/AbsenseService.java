package com.geeker.love.service.impl;

import com.geeker.love.dao.AbsenseMapper;
import com.geeker.love.pojo.absense;
import com.geeker.love.service.AbsenseServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenseService implements AbsenseServe {
    @Autowired
    private AbsenseMapper absenseMapper;
    public List<absense> getAb(Integer type){
        return absenseMapper.getAb(type);
    }
}
