package com.chinatechstar.data.service;

import com.chinatechstar.data.entity.ProsonDateils;

import java.util.HashMap;
import java.util.Map;

public interface UsersService {
    HashMap<String, Object> addUserMassage(Map map);

    HashMap<String, Object> addUserMassagesss(Map map);


    public ProsonDateils queryprosoDateils(String userIdcard);

    void addRecords(Map map);
}
