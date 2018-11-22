package com.lv.controller;

import com.lv.model.GoodEntity;
import com.lv.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: simperLv
 * DATE: 2018/11/14
 * TIME: 16:38
 *
 * @Description //TODO
 * github: https://github.com/simperLv
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private GoodService goodService;

    /**
     * 查询商品列表
     * @return
     */
    @RequestMapping("/list")
    public List<GoodEntity> list(){
        return goodService.list();
    }
}
