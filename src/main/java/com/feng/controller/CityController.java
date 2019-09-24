package com.feng.controller;

import com.feng.entity.City;
import com.feng.mapper.CityMapper;
import com.feng.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/6/1
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/all/ds1")
    public List<City> getAllCityDs1(){
        return cityService.ds1();
    }

    @GetMapping("/all/ds2")
    public List<City> getAllCityDs2(){
        return cityService.ds2();
    }

}
