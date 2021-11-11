package com.geeker.love.service.impl;

import com.geeker.love.dao.uploadFileMapper;
import com.geeker.love.pojo.image;
import com.geeker.love.service.uploadFileServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class uploadFileService implements uploadFileServe {
    @Autowired
    private uploadFileMapper uploadFileMapper;
    public void uploadPics(List<image> image) {
        uploadFileMapper.uploadPics(image);
    }
}
