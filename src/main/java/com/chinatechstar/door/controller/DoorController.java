package com.chinatechstar.door.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.component.commons.result.ResultBuilder;
import com.chinatechstar.door.utils.HttpClientUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/door")
public class DoorController {




    /*public static void main(String[] args) throws Exception {
        String url = "https://mztapp.fujian.gov.cn:9089/mztsfrz/dataset/AppSerController/invokeservice.do";
        Map<String,Object> paramsMap = new HashMap<String,Object> ();
        paramsMap.put("INVOKESERVICE_CODE","H038");
        paramsMap.put("INVOKECALLER_CODE","2c9bbe697dd997e0017e094e5b4e04152c9bbe697dd997e0");
        paramsMap.put("USER_ID","18650089799");
        paramsMap.put("USER_TOKEN","fzg+0208");
        String POSTPARAM_JSON = JSON.toJSONString(paramsMap);
        Map<String,Object> clientParam = new HashMap<String,Object>();
        clientParam.put("POSTPARAM_JSON", POSTPARAM_JSON);
        String result = HttpClientUtils.sendPostParams (url, clientParam);
        System.out.println(result);
    }*/
    /**
     * 个人信息查询
     * @param stringMap
     * @return
     *//*
    @PostMapping("getPersonInfo")
    public JSONObject getPersonInfo(@RequestBody Map<String,String> stringMap){
        String url = "http://192.168.1.87:8082/archs/public/service/getPersonInfo";
        JSONObject jsonObject = HttpClientUtils.httpPost ( url,stringMap);
        return jsonObject;
    }

    *//**
     * POST 机构查询
     * @param stringMap
     * @return
     *//*
    @PostMapping("queryOrg")
    public JSONObject queryOrg(@RequestBody Map<String,String> stringMap){
        String url = "http://192.168.1.87:8082/archs/public/service/queryOrg";
        JSONObject jsonObject = HttpClientUtils.httpPost ( url,stringMap);
        System.out.println (jsonObject);
        return jsonObject;
    }
    @PostMapping("uplodfile")
    public JSONObject uplodfile(@RequestBody Map<String,String> stringMap){
        String url = "http://192.168.1.87:8082/archs/public/service/uplodfile";
        JSONObject jsonObject = HttpClientUtils.httpPost ( url,stringMap);
        return jsonObject;
    }
    @PostMapping("downLoadFile")
    public JSONObject downLoadFile(@RequestBody Map<String,String> stringMap){
        String url = "http://192.168.1.87:8082/archs/public/service/downLoadFile";
        JSONObject jsonObject = HttpClientUtils.httpPost ( url,stringMap);
        return jsonObject;
    }*/

}