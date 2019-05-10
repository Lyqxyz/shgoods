package com.shgoods.goods.controller;

import com.shgoods.goods.service.SolrService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SolrService solrService;

    @ResponseBody
    @GetMapping("/{keyWords}")
    public Object search(@PathVariable(value = "keyWords")String kw){


        ResponseVo all = solrService.all(kw);

        return all;
    }
}
