package com.chinatechstar.data.service.impl;

import com.chinatechstar.data.mapper.UseraMapper;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.data.util.NewRandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional
public class UsersServiceimpl implements UsersService {

    @Autowired
    private UseraMapper useraMapper;

    @Override
    public void addUserMassage(HashMap<Object, String> map) {
        String newRandomCode = NewRandomCode.getNewRandomCode ( 18 );
        map.put ( "ID",newRandomCode.toString () );
        useraMapper.addUserMassage(map);
    }
}
