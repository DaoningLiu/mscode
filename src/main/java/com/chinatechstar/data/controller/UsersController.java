package com.chinatechstar.data.controller;

import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.component.commons.result.ResultBuilder;
import com.chinatechstar.data.entity.Records;
import com.chinatechstar.data.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping ("loginUser")
    public ListResult<Object> loginUser(@RequestParam(required = false) Map map){
        HashMap<String,Object> objectHashMap= usersService.addUserMassage(map);
        return ResultBuilder.buildListSuccess ( objectHashMap );
    }

    @GetMapping ("test")
    public ListResult<Object> test(@RequestParam(required = false) Map map){
        HashMap<String,Object> objectHashMap= usersService.addUserMassagesss(map);
        return ResultBuilder.buildListSuccess ( objectHashMap );
    }
    @PostMapping("addRecords")
    public ListResult<Object> addRecords(@RequestBody Records records){
        usersService.addRecords(records);
        return ResultBuilder.buildListSuccess ( "新增成功" );
    }

    @GetMapping("getRecords")
    public Records getRecords(@RequestParam (required = false) Map map){

        return usersService.getRecords(map);
    }
}
