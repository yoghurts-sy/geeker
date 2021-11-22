package com.geeker.love.service;

import com.geeker.love.utils.ResultInfo;


public interface FeedBackServe {
    ResultInfo FeedBack(Integer fid,String data);
    ResultInfo getFeedBack(Integer fid,Integer pageNum);
}
