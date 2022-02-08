package com.example.test2.Service.PrimaryService.Impl;

import com.example.test2.Mapper.Primary.placeForNormalMapper;
import com.example.test2.Service.PrimaryService.PlaceForNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("PlaceForNormalService")
public class PlaceForNormalServiceImpl implements PlaceForNormalService {

    private placeForNormalMapper placeForNormalMapper;

    @Autowired
    public PlaceForNormalServiceImpl(com.example.test2.Mapper.Primary.placeForNormalMapper placeForNormalMapper) {
        this.placeForNormalMapper = placeForNormalMapper;
    }

    @Override
    public HashMap<Object, Object> getPlaceById(Long place_id) {
        return placeForNormalMapper.getPlaceById(place_id);
    }
}
