package com.geeker.love.service.impl;

import com.geeker.love.dao.FeedBackMapper;
import com.geeker.love.pojo.feedback;
import com.geeker.love.service.FeedBackServe;
import com.geeker.love.utils.ResultInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedBackService implements FeedBackServe {
    @Autowired
    private FeedBackMapper feedBackMapper;
    @Transactional
    public ResultInfo FeedBack(Integer fid, String data) {
        ResultInfo resultInfo=new ResultInfo();
        feedBackMapper.FeedBack(fid,data);
        resultInfo.setMsg("反馈成功");
        resultInfo.setCode(200);
        return resultInfo;
    }

    public ResultInfo getFeedBack(Integer fid,Integer pageNum) {
        ResultInfo resultInfo=new ResultInfo();
        PageHelper.startPage(pageNum,5);
        List<feedback> lists=feedBackMapper.getFeedBack(fid);
        resultInfo.setCode(200);
        resultInfo.setObj(lists);
        resultInfo.setMsg("获取成功 ");
        return resultInfo;
    }
}
