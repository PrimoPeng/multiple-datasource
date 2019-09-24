package com.feng.mapper;

import com.feng.entity.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/6/1
 */
public interface CityMapper {

    @Select("select code, name, province_code from city order by code asc limit 1")
    List<City> getAllCity();

}
