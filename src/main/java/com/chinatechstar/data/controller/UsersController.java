package com.chinatechstar.data.controller;

import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.component.commons.result.ResultBuilder;
import com.chinatechstar.data.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("addUserMassage")
    public ListResult<Object> addUserMassage(@RequestBody HashMap<Object,String> map){
        usersService.addUserMassage(map);
        return ResultBuilder.buildListSuccess ( "成功" );
    }
}
