package com.chinatechstar.data.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;
import com.chinatechstar.data.mapper.UseraMapper;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.data.util.NewRandomCode;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import com.google.gson.Gson;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
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
    public void addRecords(Map map) {
        useraMapper.addRecords(map);
    }


    @Override
    public Records getRecords(Map map) {
        return useraMapper.getRecords(map);
    }

    @Override
    public ProsonDateils queryUserById(String userIdcard) {
        return useraMapper.queryUserById(userIdcard);
    }

    @Override
    public void updateRecords(Map map) {
        useraMapper. updateRecords(map);
    }

    public static void main(String[] args) throws Exception {
        String text = "{\"eventId\": \"5f4575636d144a59ba47eff4c739eeff\",\"ddc001\": \"001\",\"ddc002\": \"刘道宁\",\"ddc003\": \"1321251555511232152\",\"ddc004\": \"18518288235\",\"materialType\": \"学位材料\"}";
        final byte[] decode = HttpClientUtils.decode ( MyEnum.PRIVATES_KEY.getDesc ());
        final byte[] decodes = HttpClientUtils.decode ( MyEnum.PUVBLIC_KEY.getDesc ());
        SM2 sm2 = SmUtil.sm2(decode, decodes);
        String sss="04d708768c9d0c7814cb286b645ffacbb70b5151e13d7a36314e3967913cf533a70753be54e5e9772ea3177888f91a58ee67b1415259aa78aea26817d594a362973219e3ae5789f7e0badc5a7761c2bc62a1c939be5710ac0c11d98e0c1553c3e56f9df951f952768a722129e981794f767447aa20bd67752d2be1b156bb78168c382d6f";
        //System.out.println (bytes);

        // 公钥加密
       // String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        //System.out.println (encryptStr);
        //私钥解密
       String s = sm2.decryptStr ( sss, KeyType.PrivateKey );
        System.out.println (s);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(sss, KeyType.PrivateKey));
        System.out.println (decryptStr);
    }
    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /*public static void main(String[] args) {
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        PrivateKey aPrivate = pair.getPrivate();
        byte[] privateKey = aPrivate.getEncoded();//解密时需要用到
        PublicKey aPublic = pair.getPublic();
        byte[] publicKey = aPublic.getEncoded();//解密时需要用到

        //将q值提取出来并且转成16进制
        String q = HexUtil.encodeHexStr(((BCECPublicKey)aPublic).getQ().getEncoded(false));
        System.out.println ("后端私钥"+privateKey);
        System.out.println ("H端G钥"+publicKey);
        System.out.println ("Q端G钥"+q );

    }*/


}
