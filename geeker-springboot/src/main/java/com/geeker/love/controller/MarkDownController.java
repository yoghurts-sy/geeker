package com.geeker.love.controller;

import com.geeker.love.pojo.MarkDown;
import com.geeker.love.service.MarkDownServe;
import com.geeker.love.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.util.Date;

@RestController
@RequestMapping("/love/api")
public class MarkDownController {
    @Autowired
    MarkDownServe markDownServe;
    @PostMapping("/upload")
    public ResultInfo upload(@RequestParam(value = "file") MultipartFile file,Integer user_id,String description){
        String name=file.getOriginalFilename();
        String title=name.substring(0,name.lastIndexOf("."));
        String content=null;
        try{
            byte[] bytes=file.getBytes();
            content=new String(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        MarkDown markDown=new MarkDown(0,user_id,title,description,content,new Date().getTime(),0);
        if(markDownServe.upload(markDown)){
           return ResultInfo.success("上传成功");
        }else{
           return ResultInfo.fail("上传失败");
        }
    }

    @GetMapping("/getMd")
    public ResultInfo getMd(@RequestParam Integer user_id,Integer pageNum){
      return  ResultInfo.success(markDownServe.getMdByUId(user_id,pageNum));
    }


}
