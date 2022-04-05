package com.chinatechstar.data.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSON;
import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;
import com.chinatechstar.data.mapper.UseraMapper;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.data.util.NewRandomCode;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UsersServiceimpl implements UsersService {

    @Autowired
    private UseraMapper useraMapper;

    @Override
    public HashMap<String, Object> addUserMassage(Map map) {
        String code = map.get ( "code" ).toString ();
        MyEnum enumByCode = MyEnum.getEnumByCode ( code );
        if(enumByCode == MyEnum.LOG_IN){
            String desc = enumByCode.getDesc ();
            HashMap<String,Object> paramsMap = new HashMap<String,Object>();
            paramsMap.put("INVOKESERVICE_CODE","103");
            paramsMap.put("INVOKECALLER_CODE","2c9bbe697dd997e0017e094e5b4e04152c9bbe697dd997e0");
            paramsMap.put("TRUST_TICKET",map.get ( "trustticket" ));
            String POSTPARAM_JSON = JSON.toJSONString(paramsMap);
            HashMap<String,Object> clientParam = new HashMap<String,Object>();
            clientParam.put("POSTPARAM_JSON", POSTPARAM_JSON);
            String result = HttpClientUtils.sendPostParams(desc, clientParam);
            Map parse=(Map) JSON.parse ( result );
            //System.out.println ("这是原始数据====="+str);
            //String substring = str.substring ( 5 );
            //System.out.println ("这是截取前面之后========"+substring);
            //String substring1 = substring.substring (0, substring.length () - 1 );
            //System.out.println ("这是截取后面之后========"+substring1);
            //Map parse =(Map) JSON.parse ( substring1 );
            Map data =(Map) parse.get ( "data" );
            System.out.println (data);
            String userIdcard = data.get ( "USER_IDCARD" ).toString ();
            String useraccount = data.get ( "USER_ACCOUNT" ).toString ();
            ProsonDateils prosonDateils=useraMapper.queryUserByIdCard(userIdcard);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String s = NewRandomCode.getNewRandomCode ( 18 );
            if (prosonDateils == null){
                hashMap.put ("ID",s);
                Map map1=new HashMap<String,String> ();
                map1.put ( "id",s);
                map1.put ( "name",useraccount );
                map1.put ( "personNumber",data.get ( "USER_MOBILE" ).toString () );
                map1.put ( "personCard",data.get ( "USER_IDCARD" ).toString () );
                addUserMassagesss ( map1 );
            }else{
                hashMap.put ("ID",prosonDateils.getId ()  );
            }
            hashMap.put ( "idCard",new StringBuilder (userIdcard).replace ( 2,16,"**************" ) );
            hashMap.put ( "name",new StringBuilder (useraccount).replace ( 1,2,"*" ) );
            hashMap.put ( "personNumber",new StringBuilder (data.get ( "USER_MOBILE" ).toString ()).replace ( 3,7,"****" ) );
            return hashMap;
        }
        return null;
    }

    @Override
    public HashMap<String, Object> addUserMassagesss(Map map) {
        useraMapper.addUserMassage ( map );
        return null;
    }
    public ProsonDateils queryprosoDateils(String userIdcard){


        ProsonDateils prosonDateils=useraMapper.queryUserByIdCard(userIdcard);

        return prosonDateils;
    }

    @Override
    public void addRecords(Records records) {
        useraMapper.addRecords(records);
    }

    @Override
    public Records getRecords(Map map) {
        return useraMapper.getRecords(map);
    }

    @Override
    public void updateRecords(Records records) {
        useraMapper.updateRecords(records);
    }

    public static void main(String[] args) throws Exception {
        String text = "我是一段测试aaaa";
        final byte[] decode = HttpClientUtils.decode ( MyEnum.PRIVATES_KEY.getDesc ());
        final byte[] decodes = HttpClientUtils.decode ( MyEnum.PUVBLICS_KEY.getDesc ());
        String ssss="048AD9EEC0D14E7A20987C63E6CED805B136A924327BBF0AF8405B20B935E2542D142A8B2494A0F5A03C1CAD4B5498BAEC03AD63802BE31DE8699D014F3D021F42FA238C59D74FD704321BEAED030FDD00B30D7838A5C8457B1BDF7C5836A1E5D6B053EF7C0E421EB6B478B76108871A6FE7FFB8A51C98D872A4EFBEEC166B34E160C02B00166BF284C68891011D686E7C79C43E29724E8ED1DD7E6E6675FB0BE2EF95835E224C06C26077279DCBC71AA9B985B0C26428E244223A86B1C48263E6533B995932A5E2B6D1ADE276A551D682662D5DC5D4E20D9BF2F7985B80A06A6326359A34685898295EF1A5145B749122E702EB12F3C7FBBA319309DE1B5CED6A8E8EB5726C27A2C09CB8CCF161787B6D";

        SM2 sm2 = SmUtil.sm2(decode, decodes);
        // 公钥加密
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        System.out.println (encryptStr);
        //私钥解密
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        System.out.println (decryptStr);
    }
}
