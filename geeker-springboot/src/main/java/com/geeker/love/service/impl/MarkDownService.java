package com.geeker.love.service.impl;

import com.geeker.love.dao.MarkDownMapper;
import com.geeker.love.pojo.MarkDown;
import com.geeker.love.service.MarkDownServe;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkDownService implements MarkDownServe {
    @Autowired
    private MarkDownMapper markDownMapper;


    @Override
    public boolean upload(MarkDown markDown) {
      boolean isSuccess=markDownMapper.upload(markDown);
      return isSuccess;
    }

    @Override
    public List<MarkDown> getMdByUId(Integer uid,Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<MarkDown> list=markDownMapper.getMdByUId(uid);
        return list;
    }
}
