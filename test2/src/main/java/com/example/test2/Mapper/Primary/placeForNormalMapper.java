package com.example.test2.Mapper.Primary;


import com.example.test2.POJO.PlaceForNormal;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;


public interface placeForNormalMapper {

    public HashMap<Object,Object> getPlaceById(Long place_id);

}
