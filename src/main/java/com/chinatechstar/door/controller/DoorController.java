package com.chinatechstar.door.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.door.service.DoorService;
import com.chinatechstar.door.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map queryApplyDetail(@RequestBody Map<String,String> stringMap) throws Exception {
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

    //POST 档案转递申请
    //POST /public/service/applyFileTransfer
    /**
     * 提交预约时间
     * @param stringMap
     * @return
     */
    @PostMapping("applyFileTransfer")
    public Map applyFileTransfer(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.applyFileTransfer(stringMap);
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
     * 档案转递材料补充提交
     * @param stringMap
     * @return
     */
    @PostMapping("applyFileCommitment")
    public Map applyFileCommitment(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.applyFileCommitment(stringMap);
        return map;
    }
    /**
     * 档案资料复印
     * @param stringMap
     * @return
     */
    @PostMapping("applyCopy")
    public Map applyCopy(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.applyCopy(stringMap);
        return map;
    }
    /**
     * 档案材料补充申请
     * @param stringMap
     * @return
     */
    @PostMapping("supplementaryDossier")
    public Map supplementaryDossier(@RequestBody Map<String,String> stringMap) throws Exception {
        Map map =doorService.supplementaryDossier(stringMap);
        return map;
    }
    /**
     * 档案所在地查询
     * @param stringMap
     * @return
     */
    @PostMapping("getPersonInfo")
    public Map getPersonInfo(@RequestBody  Map<String,String> stringMap) throws Exception {
        Map map =doorService.getPersonInfo(stringMap);
        System.out.println (map);
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
    /**
     * 开具证明申请
     * @param stringMap
     * @return
     * @throws Exception
     */
    @PostMapping("issueProve")
    public Map issueProve(@RequestBody  Map<String,String> stringMap) throws Exception {
        Map map =doorService.issueProve(stringMap);
        System.out.println (map);
        return map;
    }

    /**
     * 申请数据查询
     * @param stringMap
     * @return
     * @throws Exception
     */
    @PostMapping("queryApply")
    public Map queryApply(@RequestBody  Map<String,String> stringMap) throws Exception {
        Map map =doorService.queryApply(stringMap);
        System.out.println (map);
        return map;
    }
    /*@PostMapping("uplodfile")
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
    }*/

}
