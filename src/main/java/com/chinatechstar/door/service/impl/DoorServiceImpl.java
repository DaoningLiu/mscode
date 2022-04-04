package com.chinatechstar.door.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.door.service.DoorService;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

@Service
public class DoorServiceImpl implements DoorService {
    @Autowired
    private UsersService usersService;

    /**
     * 查询办理详情
     * @param stringMap
     * @return
     */
    @Override
    public Map queryApplyDetail(Map<String, String> stringMap) throws Exception {
        String url = "http://192.168.1.87:8082/archs/public/service/queryApplyDetail";
        String data = stringMap.get ( "data" );
        final byte[] privatesKey = HttpClientUtils.decode ( MyEnum.PRIVATES_KEY.getDesc ());
        SM2 sm2s = SmUtil.sm2(privatesKey, null);
        //私钥解密
        Map decryptStr = (Map) JSONObject.toJSON (StrUtil.utf8Str(sm2s.decryptFromBcd(data, KeyType.PrivateKey)) );
        ProsonDateils prosonDateils=usersService.queryprosoDateils (stringMap.get ( "userIdcard" ));
        decryptStr.put ( "userNo",prosonDateils.getPersonCard () );
        Map<String,Object> paramsMap = new HashMap<String,Object> ();
        final byte[] privateKey = HttpClientUtils.decode ( MyEnum.PRIVATE_KEY.getDesc ());
        final byte[] pulicKey = HttpClientUtils.decode ( MyEnum.PUVBLIC_KEY.getDesc ());
        SM2 sm2 = SmUtil.sm2(privateKey, pulicKey);
        // 公钥加密
        String encryptStr = sm2.encryptBcd(decryptStr.toString (), KeyType.PublicKey);
        paramsMap.put ( "data",encryptStr );
        JSONObject jsonObject = HttpClientUtils.httpPost ( url,stringMap);
        Map maps=jsonObject;

        return maps;
    }
}
