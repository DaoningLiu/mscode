package com.chinatechstar.door.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.data.util.NewRandomCode;
import com.chinatechstar.door.service.DoorService;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.rmi.MarshalledObject;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        //生成url访问接口
        String url = "http://192.168.1.87:8082/archs/public/service/queryApplyDetail";
        //获取前端传过来的数据
        String data = stringMap.get ( "data" );
        //获取自己使用的私钥用于解密前端数据
        final byte[] privatesKey = HttpClientUtils.decode ( MyEnum.PRIVATES_KEY.getDesc ());
        //将私钥放到sm2里便于使用，当前不需要公钥所以就以null代替
        SM2 sm2s = SmUtil.sm2(privatesKey, null);
        //私钥解密
        Map decryptStr = (Map) JSONObject.toJSON (StrUtil.utf8Str(sm2s.decryptFromBcd(data, KeyType.PrivateKey)) );
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryprosoDateils (stringMap.get ( "userIdcard" ));
        //获取当前用户身份证号用于访问银海接口
        decryptStr.put ( "userNo",prosonDateils.getPersonCard () );
        //new一个map用于访问接口因为加密数据里本身就是一个map以data定义的key，value对
        Map paramsMap = new HashMap ();
        //获取银海的公钥私钥
        final byte[] privateKey = HttpClientUtils.decode ( MyEnum.PRIVATE_KEY.getDesc ());
        final byte[] pulicKey = HttpClientUtils.decode ( MyEnum.PUVBLIC_KEY.getDesc ());
        //将银海的公钥私钥放入sm2对象中用于加密咱们的数据访问他们的 数据，解密他们返回的数据库
        SM2 sm2 = SmUtil.sm2(privateKey, pulicKey);
        // 公钥加密
        String encryptStr = sm2.encryptBcd(decryptStr.toString (), KeyType.PublicKey);
        //将加密的数据放入新建的map里加密数据为value，data为key
        paramsMap.put ( "data",encryptStr );
        //访问他们的接口接收返回值
        Map jsonObject = HttpClientUtils.httpPost ( url,paramsMap);
        //获取银海接口返回的加密字符串
        String datas = jsonObject.get ( "data" ).toString ();
        //私钥解密，并将解密完成的数据强转成字符串
        Map datass = (Map) JSONObject.toJSON (StrUtil.utf8Str(sm2.decryptFromBcd(datas, KeyType.PrivateKey)));
        //通过user_id,user_code查询当前用户是否有当前业务炒作记录

                Records records =new Records ();
                records.setId ( NewRandomCode.getNewRandomCode ( 18 ) );
                Date date = new Date ();
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat ("yyyy-mm-ss hh:mm");
                records.setAccab19 ( simpleDateFormat.format ( date ) );
                records.setDdc001 (decryptStr.get ( "ddc001" ) .toString () );
                if(decryptStr.get ( "ddc002" ) .toString ()==null){
                    records.setDdc002 (prosonDateils.getPersonName ());
                    records.setDdc003 ( prosonDateils.getPersonCard () );
                    records.setDdc004 ( prosonDateils.getPersonNumber ().toString () );
                }else{
                    records.setDdc002 (decryptStr.get ( "ddc002" ) .toString ());
                    records.setDdc003 (decryptStr.get ( "ddc003" ) .toString () );
                    records.setDdc004 (decryptStr.get ( "ddc004" ) .toString () );
                }
                records.setMaterialType ( decryptStr.get ( "materialType" ).toString () );
                records.setRecordsText ( datass.toString () );
                records.setUserId ( prosonDateils.getId () );
                records.setUserCode ( "110" );
        return jsonObject;
    }

    public static void main(String[] args) {
        /*Date date = new Date ();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat ("yyyy-mm-ss hh:mm");
        String format = simpleDateFormat.format ( date );
        System.out.println (format);*/
        String text = "我是一段测试aaaa";

        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        byte[] privateKey = pair.getPrivate().getEncoded();
        byte[] publicKey = pair.getPublic().getEncoded();
        BASE64Encoder encoder = new BASE64Encoder ();
        System.out.println ("二进制++++++======="+privateKey.toString ());
        System.out.println (encoder.encode(privateKey)+"后边是公钥");
        System.out.println (encoder.encode(publicKey));
        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
            // 公钥加密，私钥解密
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
       // System.out.println (encryptStr);
        //System.out.println (decryptStr);
    }
}
