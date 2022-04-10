package com.chinatechstar.door.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.entity.Records;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.data.util.NewRandomCode;
import com.chinatechstar.door.service.DoorService;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/queryApplyDetail" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        mapKey.put ( "data",stringMap.get ( "data" ) );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        //获取当前用户身份证号用于访问银海接口
        mapKey.put ( "personCard",prosonDateils.getPersonCard ()  );
        //定义银海访问接口所需参宿
        Map paramsMapss = new HashMap ();
        //将身份证号码传入
        paramsMapss.put ( "userNo",prosonDateils.getPersonNation ());
        //将用户id传入
        paramsMapss.put ( "eventId",decryptStr.get ("eventId") );
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(paramsMapss ));
        //访问他们的接口接收返回值
        Map yhMap = jsonObject ( mapKey );
        Map map =new HashMap ();
        //银海返回值所以数据
        map.put ( "yhtext",yhMap.toString () );
        //前端传过来的加密字符串
        map.put ( "data",stringMap.get ( "data" ) );
        //获取用户id
        map.put ( "userIdcard",stringMap.get ( "userIdcard" ));
        //定义一个自己接口的状态码用于区分不同接口
        map.put ( "userCode","101" );
        //执行判断自己数据库是否有属于这个接口的操作记录，返回值之后如果数据不全自行获取
        Map returnMap = getReturnMap ( map );
        return returnMap;
    }


    //POST 档案资料借阅
    //POST /public/service/applyArchiveBorrow
    /**
     * 档案资料借阅
     * @param stringMap
     * @return
     */
    @Override
    public Map applyArchiveBorrow(Map<String, String> stringMap) throws Exception {

        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/applyArchiveBorrow" );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //获取用户的手机号 身份证号码 并且赋值
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        decryptStr.put ("userNo",prosonDateils.getPersonCard ());
        decryptStr.put ("aac147",prosonDateils.getPersonCard ());
        decryptStr.put ("aac067",prosonDateils.getPersonNumber ());
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(decryptStr ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }


    //POST 医社保借阅申请
    //POST /public/service/applyCHSandSI
    /**
     * 医社保借阅申请
     * @param stringMap
     * @return
     */
    @Override
    public Map applyCHSandSI(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/applyCHSandSI" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //获取用户的手机号 身份证号码 并且赋值
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        decryptStr.put ("userNo",prosonDateils.getPersonCard ());
        decryptStr.put ("aac147",prosonDateils.getPersonCard ());
        decryptStr.put ("aac067",prosonDateils.getPersonNumber ());
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(decryptStr ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }

    //POST 政审预约申请
    //POST /public/service/applyInspect
    /**
     * 政审预约申请
     * @param stringMap
     * @return
     */
    @Override
    public Map applyInspect(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/applyInspect" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //获取用户的手机号 身份证号码 并且赋值
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        decryptStr.put ("userNo",prosonDateils.getPersonCard ());
        decryptStr.put ("aac147",prosonDateils.getPersonCard ());
        decryptStr.put ("aac067",prosonDateils.getPersonNumber ());
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(decryptStr ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }

    //POST 提交预约时间
    //POST /public/service/commit/time
    /**
     * 提交预约时间
     * @param stringMap
     * @return
     */
    @Override
    public Map commitTime(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/commit/time" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //获取用户的手机号 身份证号码 并且赋值
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        decryptStr.put ("userNo",prosonDateils.getPersonCard ());
        decryptStr.put ("aac147",prosonDateils.getPersonCard ());
        decryptStr.put ("aac067",prosonDateils.getPersonNumber ());
        decryptStr.remove ( "userIdcard" );
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(decryptStr ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }

    /**
     * 档案转递材料补充提交
     * @param stringMap
     * @return
     */
    @Override
    public Map applyFileCommitment(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/applyFileCommitment" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //mapKey.put ( "data",stringMap.get ( "data" ) );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        mapKey.put ( "userNo",prosonDateils.getPersonCard () );
        mapKey.put ( "aac147",prosonDateils.getPersonCard () );
        mapKey.put ( "aac067",prosonDateils.getPersonNumber () );
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(mapKey ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }
    /**
     * 档案资料复印
     * @param stringMap
     * @return
     */
    @Override
    public Map applyCopy(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/applyCopy" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //mapKey.put ( "data",stringMap.get ( "data" ) );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        mapKey.put ( "userNo",prosonDateils.getPersonCard () );
        mapKey.put ( "aac147",prosonDateils.getPersonCard () );
        mapKey.put ( "aac067",prosonDateils.getPersonNumber () );
        mapKey.put ( "yhPost",JSONUtils.toJSONString(mapKey ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }
    /**
     * 档案材料补充申请
     * @param stringMap
     * @return
     */
    @Override
    public Map supplementaryDossier(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/supplementaryDossier" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //mapKey.put ( "data",stringMap.get ( "data" ) );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        mapKey.put ( "userNo",prosonDateils.getPersonCard () );
        mapKey.put ( "aac147",prosonDateils.getPersonCard () );
        mapKey.put ( "aac067",prosonDateils.getPersonNumber () );
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(mapKey ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }

    @Override
    public Map getPersonInfo(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/getPersonInfo" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //mapKey.put ( "data",stringMap.get ( "data" ) );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        mapKey.put ( "userNo",prosonDateils.getPersonCard () );
        mapKey.put ( "aac147",prosonDateils.getPersonCard () );
        //mapKey.put ( "aac067",prosonDateils.getPersonNation () );
        mapKey.put ( "aac003",prosonDateils.getPersonName () );
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(mapKey ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }

    /**
     * 档案转递申请
     * @param stringMap
     * @return
     */
    @Override
    public Map applyFileTransfer(Map<String, String> stringMap) throws Exception {
        //调用银海接口所需要的数据
        Map mapKey =new HashMap ();
        //传入要访问的接口路径
        mapKey.put ( "url",MyEnum.YH_URL.getDesc ()+"/archs/public/service/getPersonInfo" );
        //还有前端传回来的加密字符串格式{"data":"加密字符串"}
        //mapKey.put ( "data",stringMap.get ( "data" ) );
        //私钥解密前端传回的数据，因为这边也需要解密完成的数据
        Map decryptStr = getMapToString (stringMap.get ( "data" )  );
        //根据前端传过来的数据查询当前操作数据
        ProsonDateils prosonDateils=usersService.queryUserById (decryptStr.get ( "userIdcard" ).toString ());
        mapKey.put ( "userNo",prosonDateils.getPersonCard () );
        mapKey.put ( "aac147",prosonDateils.getPersonCard () );
        mapKey.put ( "aac067",prosonDateils.getPersonNation () );
        //mapKey.put ( "aac003",prosonDateils.getPersonName () );
        //定义银海访问接口所需参宿
        //将参数转成字符串放入map中，JSONUtils.toJSONString(paramsMapss )这个方法可以保留map格式
        mapKey.put ( "yhPost",JSONUtils.toJSONString(mapKey ));
        //访问他们的接口接收返回值 直接对其前端返回不对其改动
        return jsonObject ( mapKey );
    }


    static Map jsonObject(Map map) throws Exception {
        //生成url访问接口
        String url = map.get("url").toString ();
        Map paramsMap = new HashMap ();
        //获取银海的公钥私钥
        final byte[] privateKey = HttpClientUtils.decode ( MyEnum.PRIVATE_KEY.getDesc ());
        final byte[] pulicKey = HttpClientUtils.decode ( MyEnum.PUVBLIC_KEY.getDesc ());
        //将银海的公钥私钥放入sm2对象中用于加密咱们的数据访问他们的 数据，解密他们返回的数据库
        SM2 sm2 = SmUtil.sm2(privateKey, pulicKey);
        //System.out.println ("dddddddddddddd"+ map.get ( "yhPost" ).toString ());
        // 公钥加密
        String encryptStr = sm2.encryptBcd( map.get ( "yhPost" ).toString (), KeyType.PublicKey);
        //将加密的数据放入新建的map里加密数据为value，data为key
        paramsMap.put ( "data",encryptStr );
        //System.out.println ("加密和要去请求数据格式"+JSONUtils.toJSONString(paramsMap));
        //访问他们的接口接收返回值
        JSONObject jsonObject = HttpClientUtils.httpPost ( url, paramsMap );
        String datas = jsonObject.get ( "data" ).toString ();
        Map datass = new HashMap ();
        if(datas.length ()>4){
            datass =  retunMap(JSONObject.toJSON (StrUtil.utf8Str(sm2.decryptFromBcd(datas, KeyType.PrivateKey))).toString ());
        }
        return datass;
    }
    static Map getMapToString(String string) throws Exception {
        final byte[] decode = HttpClientUtils.decode ( MyEnum.PRIVATES_KEY.getDesc ());
        final byte[] decodes = HttpClientUtils.decode ( MyEnum.PUVBLICS_KEY.getDesc ());
        SM2 sm2 = SmUtil.sm2(decode, decodes);
        //私钥解密
        //Map decryptStr = retunMap(JSONObject.toJSON (StrUtil.utf8Str(sm2s.decryptFromBcd(string, KeyType.PrivateKey)) ).toString ()) ;
        String s = sm2.decryptStr ( string, KeyType.PrivateKey );
        Map decryptStr = retunMap(s );

        return decryptStr;
    }



     Map getReturnMap(Map maps) throws Exception {
        ProsonDateils prosonDateils=usersService.queryUserById (maps.get ( "userIdcard" ).toString ());
        Map decryptStr = getMapToString (maps.get ( "data" ).toString ()  );
        Map mapQuery =new HashMap ();
        mapQuery.put ( "userId",prosonDateils.getId ());
        mapQuery.put ( "userCode",maps.get ( "userCode" ) );
        Records records = usersService.getRecords ( mapQuery );
        Map map = new HashMap ();
        Map mapkey = new HashMap ();
        if(records == null ){
            Date date = new Date ();
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat ("yyyy-mm-ss hh:mm");
            mapkey.put ( "id",NewRandomCode.getNewRandomCode ( 18 ) );
            mapkey.put ( "accab19", simpleDateFormat.format ( date ));
            mapkey.put ( "ddc001", decryptStr.get ( "ddc001" ) .toString ());
            if(decryptStr.get ( "ddc002" ) .toString ()==null){
                mapkey.put ( "ddc002", prosonDateils.getPersonName ());
                mapkey.put ( "ddc003", prosonDateils.getPersonCard ());
                mapkey.put ( "ddc004", prosonDateils.getPersonNumber ().toString ());
            }else{
                mapkey.put ( "ddc002", decryptStr.get ( "ddc002" ) .toString ());
                mapkey.put ( "ddc003", decryptStr.get ( "ddc003" ) .toString ());
                mapkey.put ( "ddc004", decryptStr.get ( "ddc004" ) .toString ());
            }
            mapkey.put ( "materialType", decryptStr.get ( "materialType" ).toString ());
            mapkey.put ( "recordsText", maps.get ( "yhtext" ));
            mapkey.put ( "userId", prosonDateils.getId ());
            mapkey.put ( "userCode", "101");
            usersService.addRecords ( mapkey );
            map.put ( "recordsText", maps.get ( "yhtext" ));
            map.put ( "ddc003",new StringBuilder (prosonDateils.getPersonCard ()).replace ( 2,16,"**************" ) );
            map.put ( "ddc002",new StringBuilder (decryptStr.get ( "ddc002" ) .toString ()).replace ( 1,2,"*" ) );
            map.put ( "ddc004",new StringBuilder (decryptStr.get ( "ddc004" ) .toString ()).replace ( 3,7,"****" ) );
            map.put ( "idCard",new StringBuilder (prosonDateils.getPersonCard () ).replace ( 2,16,"**************" ) );
            map.put ( "name",new StringBuilder (prosonDateils.getPersonName ()).replace ( 1,2,"*" ) );
            map.put ( "personNumber",new StringBuilder (prosonDateils.getPersonNation ()).replace ( 3,7,"****" ) );
            return map;
        }else{
            //差个id赋值
            mapkey.put ( "userId",prosonDateils.getId () );
           // map.put ( "userCode","101");
            mapkey.put ( "id", records.getId ());
            mapkey.put ( "recordsText", maps.get ( "yhtext" ));
            usersService.updateRecords(mapkey);
            map.put ( "recordsText", maps.get ( "yhtext" ));
            map.put ( "ddc003",new StringBuilder (records.getDdc003 ()).replace ( 2,16,"**************" ) );
            map.put ( "ddc002",new StringBuilder (records.getDdc002 ()).replace ( 1,2,"*" ) );
            map.put ( "ddc004",new StringBuilder (records.getDdc004 ()).replace ( 3,7,"****" ) );
            map.put ( "idCard",new StringBuilder (prosonDateils.getPersonCard () ).replace ( 2,16,"**************" ) );
            map.put ( "name",new StringBuilder (prosonDateils.getPersonName ()).replace ( 1,2,"*" ) );
            map.put ( "personNumber",new StringBuilder (prosonDateils.getPersonNation ()).replace ( 3,7,"****" ) );
            return map;
        }
    }



   /* public static void main(String[] args) {
        *//*SM2 sm2= SmUtil.sm2();
        String publicKey=sm2.getPublicKeyBase64();
        String privateKey=sm2.getPrivateKeyBase64();
        System.out.println ("pub"+publicKey);
        System.out.println ("private"+privateKey);
        String s = HexUtil.encodeHexStr ( ((BCECPublicKey) sm2.getPublicKey ()).getQ ().getEncoded ( false ) );
        System.out.println ("前端"+s);*//*


        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        PrivateKey aPrivate = pair.getPrivate();
        byte[] privateKey = aPrivate.getEncoded();//解密时需要用到

        PublicKey aPublic = pair.getPublic();
        byte[] publicKey = aPublic.getEncoded();//解密时需要用到
        System.out.println (privateKey);
        System.out.println (publicKey);
        //将q值提取出来并且转成16进制
        String q = HexUtil.encodeHexStr(((BCECPublicKey)aPublic).getQ().getEncoded(false));
        System.out.println ("公钥16进制"+q);


        String text = "我是一段测试aaaa";

        //KeyPair pair = SecureUtil.generateKeyPair("SM2");
        //byte[] privateKey = pair.getPrivate().getEncoded();
        //byte[] publicKey = pair.getPublic().getEncoded();
        BASE64Encoder encoder = new BASE64Encoder ();
        System.out.println ("二进制++++++======="+privateKey.toString ());
        System.out.println ("私钥==="+encoder.encode(privateKey));
        System.out.println ("公钥==="+encoder.encode(publicKey));
        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
            // 公钥加密，私钥解密
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        System.out.println (encryptStr);
        System.out.println (decryptStr);
    }*/
    public static Map retunMap(String jsonString){
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(jsonString, map.getClass());
        return map;
    }
}
