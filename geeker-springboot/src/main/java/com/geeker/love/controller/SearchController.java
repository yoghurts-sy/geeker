package com.geeker.love.controller;

import com.geeker.love.service.impl.SearchService;
import com.geeker.love.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/love/api")
public class SearchController {
    @Autowired
    private SearchService searchService;

    /**TODO
     * 分页的功能好像不太行
     */

    @GetMapping("/scuser")
    @ResponseBody
    public ResultInfo searchUser(@RequestParam String keyword, @RequestParam Integer pageNum){
        String name = "%"+keyword+"%";
        return searchService.searchUser(name,pageNum);
    }

    @GetMapping("/scpost")
    @ResponseBody
    public ResultInfo searchPost(@RequestParam String keyword,
                                 @RequestParam Integer pageNum) {
        String keywords = "%"+keyword+"%";
        return searchService.searchPost(keywords, pageNum);
    }

    @GetMapping("/sctopic")
    @ResponseBody
    public ResultInfo searchTopic(@RequestParam String keyword,
                                   @RequestParam Integer pageNum)
    {
        String keywords = "%"+keyword+"%";
        return searchService.searchTopic(keywords,pageNum);
    }

}
