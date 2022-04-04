package com.chinatechstar.data.mapper;

import com.chinatechstar.data.entity.ProsonDateils;

import java.util.Map;

public interface UseraMapper {

    ProsonDateils queryUserByIdCard(String userIdcard);

    void addUserMassage(Map map);
}
