package com.chinatechstar.data.mapper;

import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;

import java.util.Map;

public interface UseraMapper {

    ProsonDateils queryUserByIdCard(String userIdcard);

    void addUserMassage(Map map);

    void addRecords(Records records);

    Records getRecords(Map map);
}
