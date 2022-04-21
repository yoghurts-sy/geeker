package com.geeker.love.service;

import com.geeker.love.pojo.MarkDown;
import com.github.pagehelper.PageHelper;

import java.util.List;

public interface MarkDownServe {
    boolean upload(MarkDown markDown);
    List<MarkDown> getMdByUId(Integer uid, Integer pageNum);
}
