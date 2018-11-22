package com.lv.service;

import com.lv.jpa.GoodJPA;
import com.lv.model.GoodEntity;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: simperLv
 * DATE: 2018/11/16
 * TIME: 16:39
 *
 * @Description //TODO
 * github: https://github.com/simperLv
 */
@Service
@CacheConfig(cacheNames = "good")
public class GoodService {
    @Autowired
    private GoodJPA goodJPA;

    @Cacheable
    public List<GoodEntity> list(){
        return goodJPA.findAll();
    }
}
