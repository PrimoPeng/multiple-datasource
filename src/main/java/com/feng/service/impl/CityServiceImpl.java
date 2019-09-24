package com.feng.service.impl;

import com.feng.annotation.DS;
import com.feng.entity.City;
import com.feng.mapper.CityMapper;
import com.feng.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/6/2
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @DS("ds1")
    public List<City> ds1() {
        return cityMapper.getAllCity();
    }


    @DS("ds2")
    public List<City> ds2() {
        return cityMapper.getAllCity();
    }
}
