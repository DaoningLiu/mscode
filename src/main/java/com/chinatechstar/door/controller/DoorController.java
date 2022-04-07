package com.chinatechstar.door.controller;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.door.service.DoorService;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/door")
public class DoorController {

    @Autowired
    private DoorService doorService;


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
     * 查询办理详情
     * @param stringMap
     * @return
     */
    @PostMapping("queryApplyDetail")
    public Map getPersonInfo(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.queryApplyDetail(stringMap);
        return map;
    }


    //POST 档案资料借阅
    //POST /public/service/applyArchiveBorrow
    /**
     * 档案资料借阅
     * @param stringMap
     * @return
     */
    @PostMapping("applyArchiveBorrow")
    public Map applyArchiveBorrow(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.applyArchiveBorrow(stringMap);
        return map;
    }

    //POST 医社保借阅申请
    //POST /public/service/applyCHSandSI
    /**
     * 医社保借阅申请
     * @param stringMap
     * @return
     */
    @PostMapping("applyCHSandSI")
    public Map applyCHSandSI(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.applyCHSandSI(stringMap);
        return map;
    }


    //POST 政审预约申请
    //POST /public/service/applyInspect
    /**
     * 政审预约申请
     * @param stringMap
     * @return
     */
    @PostMapping("applyInspect")
    public Map applyInspect(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.applyInspect(stringMap);
        return map;
    }


    //POST 提交预约时间
    //POST /public/service/commit/time
    /**
     * 提交预约时间
     * @param stringMap
     * @return
     */
    @PostMapping("commit/time")
    public Map commitTime(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.commitTime(stringMap);
        return map;
    }







    /**
     * POST 机构查询
     * @param stringMap
     * @return
     */
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
    public JSONObject downLoadFile(@RequestBody Map<String,String> stringMap) {
        String url = "http://192.168.1.87:8082/archs/public/service/downLoadFile";
        JSONObject jsonObject = HttpClientUtils.httpPost ( url, stringMap );
        return jsonObject;
    }

}
