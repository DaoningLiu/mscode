package com.chinatechstar.data.mapper;

import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;

import java.util.Map;

public interface UseraMapper {

    ProsonDateils queryUserByIdCard(String userIdcard);

    void addUserMassage(Map map);

    void addRecords(Map map);

    Records getRecords(Map map);

    ProsonDateils queryUserByIdCards(String userIdcard);

    ProsonDateils queryUserById(String userIdcard);

    void updateRecords(Map map);
}
