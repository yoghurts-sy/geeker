package com.geeker.love.controller;

import com.geeker.love.pojo.image;
import com.geeker.love.service.impl.uploadFileService;
import com.geeker.love.service.uploadFileServe;
import com.geeker.love.utils.ResultInfo;
import com.geeker.love.utils.uploadUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/love/api")
public class FileUploadController {
    @Autowired
    private uploadFileServe uploadFileService;
    @PostMapping("/upPics")
    @ResponseBody
    public ResultInfo upPics(@RequestParam(value = "file")List<MultipartFile> file/*,
                         @RequestParam(value = "token")String token*/){
        ResultInfo result=new ResultInfo();
      /*  if(token.isEmpty()){
            result.setCode(400);
            result.setMsg("token为空!");
            return  result;
        }
        //token验证
        try{
            Claims claims= (Claims) Jwts.parser()
                    .setSigningKey("geek")
                    .parse(token)
                    .getBody();
        }catch (Exception e){
            result.setCode(402);
            result.setMsg("用户信息异常");
            return  result;
        }*/
        //

        if(file.isEmpty()){
            System.out.println("图片为空 ");
            result.setCode(401);
            result.setMsg("图片不能为空");
            return result;
        }
      /*  Claims claims= (Claims) Jwts.parser()
                .setSigningKey("geek")
                .parse(token)
                .getBody();
        int uid=Integer.parseInt(claims.getId());*/
       List<image> images= uploadUtil.uploadfile(file,1,1);

        uploadFileService.uploadPics(images);
        result.setCode(500);
        result.setMsg("图片上传成功");
        result.setObj(images);
        return result;
    }
    @PostMapping("/updateupic")
    @ResponseBody
    public ResultInfo updateUpic(@RequestParam(value = "file")MultipartFile file/*,
                         @RequestParam(value = "token")String token*/){
        ResultInfo result=new ResultInfo();
      /*  if(token.isEmpty()){
            result.setCode(400);
            result.setMsg("token为空!");
            return  result;
        }
        //token验证
        try{
            Claims claims= (Claims) Jwts.parser()
                    .setSigningKey("geek")
                    .parse(token)
                    .getBody();
        }catch (Exception e){
            result.setCode(402);
            result.setMsg("用户信息异常");
            return  result;
        }*/
        //

        if(file.isEmpty()){
            System.out.println("图片为空 ");
            result.setCode(401);
            result.setMsg("图片不能为空");
            return result;
        }
      /*  Claims claims= (Claims) Jwts.parser()
                .setSigningKey("geek")
                .parse(token)
                .getBody();
        int uid=Integer.parseInt(claims.getId());*/
        String imageURL= uploadUtil.uploadfile(file,1);
        List<image> images=new ArrayList<>();
        images.add(new image(imageURL,1));
        uploadFileService.uploadPics(images);
        uploadFileService.updateUpic(imageURL,1);
        result.setCode(500);
        result.setMsg("图片上传成功");
        result.setObj(imageURL);
        return result;
    }

}
