package com.example.test2.Service.PrimaryService;

import com.example.test2.POJO.Area;
import com.example.test2.POJO.AreaStoreTable;

public interface AreaStoreService {

    public AreaStoreTable getAreaById(Long area_id);

    public Area convertToArea(Long area_id);
}
