package com.chinatechstar.data.service;

import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;

import java.util.HashMap;
import java.util.Map;

public interface UsersService {
    HashMap<String, Object> addUserMassage(Map map);

    HashMap<String, Object> addUserMassagesss(Map map);


    public ProsonDateils queryprosoDateils(String userIdcard);

    void addRecords(Records records);

    Records getRecords(Map map);

    void updateRecords(Records records);
}
