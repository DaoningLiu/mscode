package com.chinatechstar.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinatechstar.data.entity.ProsonDateils;
import com.chinatechstar.data.mapper.UseraMapper;
import com.chinatechstar.data.service.UsersService;
import com.chinatechstar.data.util.NewRandomCode;
import com.chinatechstar.door.utils.HttpClientUtils;
import com.chinatechstar.door.utils.MyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
            String s = NewRandomCode.getNewRandomCode ( 18 ).toString ();
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

    public static void main(String[] args) {
        String str = "";


        /*String str = "{res={\"msg\":null,\"data\":{\"ENTSTORE_IDS\":null,\"ASSOCIATIONCONTENT\":null,\"LEGALPERSON_TYPE\":null,\"IS_BINDYB\":null,\"USER_EMAIL\":null,\"WX_PROSIGN\":\"ovfmT4o5dMKvm4QnVX8_RSaaATtI\",\"USER_MOBILE\":\"13110526159\",\"LEGALPERSON_PHONE\":null,\"USER_ID\":\"2c9bbe75722944e001722a13fb3213d6\",\"USER_VISAVIEW\":-1,\"REMARKS\":null,\"USER_PASS\":\"dv4s0Dkpe4KV2G+nqxrXCg==\",\"CERT_KEY\":null,\"REGMONEY\":null,\"IS_UPDATEXM\":null,\"LEGALPERSON_JDCODE\":null,\"USER_AUTHLEVEL\":2,\"LEGALPERSON_ORGTYPE\":null,\"USER_CONFIGPASS\":\"-1\",\"GPS_SFBM\":null,\"CANCEL_TIME\":null,\"IS_APPSIGN\":1,\"LEGALPERSON_ZZJGDM\":null,\"FUNDKIND\":null,\"USER_HIGHCHANNEL\":\"gongan\",\"CERTS_VALIDDATE\":null,\"LEGALPERSON_ZGRS\":null,\"REGADDRESS\":null,\"GPS_QXBM\":null,\"POPULATION_JZDZ\":null,\"GPS_CSBM\":null,\"LEGALPERSON_ZCZB\":null,\"POPULATION_NATION\":\"01\",\"USER_GJJLX\":null,\"USER_TYPE\":1,\"LEGALPERSON_QYXZ\":null,\"POPULATION_AREACODE\":\"350425\",\"YWTYDM\":null,\"REGORGANIZER\":null,\"POPULATION_CCITYCODE\":null,\"LEGALPERSON_NCCODE\":null,\"LEGALPERSON_IDCARD\":null,\"WDMLX\":null,\"IS_SM4ENCRY\":\"1\",\"USER_JUNTIME\":null,\"CERTS_EFFECTDATE\":null,\"CARD_TYPE\":\"111\",\"USER_APPEID\":null,\"LEGALPERSON_NAME\":null,\"LEGALPERSON_JBRNAME\":null,\"DMZJ_PATH\":null,\"CORP_KEY\":null,\"USER_CITYCODE\":\"350100\",\"LEGALPERSON_FRSJH\":null,\"APPSTORE_TYPE\":\"5\",\"USER_JUNIORCHANNEL\":\"gongan\",\"YYZZ_PATH\":null,\"SFZPCS\":\"35\",\"POPULATION_HJDZ\":\"福建省大田县梅山镇黎坑村33号\",\"CZD_AREACODE\":null,\"USER_NAME\":\"吴芳燕\",\"XZQH_CODE\":\"350425\",\"SWB_PASS\":null,\"COMPETENTORG\":null,\"POPULATION_CADDRESS\":null,\"LEGALPERSON_HYMC\":null,\"POPULATION_PROCODE\":\"350000\",\"USER_REMINDTIME\":null,\"LEGALPERSON_EMAIL\":null,\"ACTAREA\":null,\"POPULATION_SEX\":1,\"SMALL_PROSIGN\":\"2088712685729166\",\"USER_ROLE\":null,\"APPLE_USERID\":null,\"USER_CALLERNAME\":\"闽政通APP\",\"LAST_MOBILE\":null,\"LEGALPERSON_ZADDRESS\":null,\"ENTERPRISECAPITAL\":null,\"USER_ERRORCOUNT\":null,\"LEGALPERSON_XKZ\":null,\"USER_TOKEN\":\"22e1aa72f5ba6565746660e71806abca2c9bc68b7fe6bc23017fe8f73f2f07eb\",\"USER_HITIME\":\"2020-05-19 07:19:31\",\"POPULATION_CPROCODE\":null,\"POPULATION_EDU\":null,\"IS_HWEID_LOGIN\":null,\"ALIPAY_CHECKFACE\":null,\"CZD_ADDRESS\":null,\"LEGALPERSON_FRXB\":null,\"LEGALPERSON_ADDRESS\":null,\"USER_UNLOCKTIME\":null,\"CZD_CITYCODE\":null,\"FUNDSOURCE\":null,\"LEGALPERSON_AREACODE\":null,\"LEGALPERSON_JJLX\":null,\"POPULATION_CAREACODE\":null,\"LEGALPERSON_DYLEVEL\":null,\"NATION_CODE\":\"CHN\",\"LEGALPERSON_ACCTYPE\":null,\"REGIST_NUM\":15417731,\"USER_ACCOUNT\":\"吴芳燕\",\"LEGALPERSON_PROCODE\":null,\"ENTERPRISEADDRESS\":null,\"LEGALPERSON_ZCITYCODE\":null,\"POPULATION_WX\":null,\"POPULATION_CITYCODE\":\"350400\",\"HUAWEI_EIDCODE\":null,\"LEGALPERSON_ZIPCODE\":null,\"REGDATE\":null,\"CERT_YXQS\":null,\"GESTURE_PASS\":\"5481b2f34a74e427a2818014b8e103b0\",\"USER_PHOTOURL\":\"https://mztapp.fujian.gov.cn:8192/mztAppFile/uploadfile/image/2/20200518/aec3ab6cbc764f60ba56e993348959ee.png\",\"SOCIALORGTYPE\":null,\"LEGALPERSON_ZAREACODE\":null,\"ENTERPRISERANGE\":null,\"USER_IDCARD\":\"350425199105133513\",\"LEGALPERSON_JBRIDCARD\":null,\"NATION_LEVEL\":4,\"POPULATION_BIRTHDAY\":\"1991-05-13\",\"ENTERPRISEBEGINDATE\":null,\"LEGALPERSON_CREAETDATE\":null,\"LEGALPERSON_XZQH\":null,\"USER_ISTEST\":-1,\"IS_UPDATESP\":null,\"IS_ST\":null,\"LEGALPERSON_NJRQ\":null,\"BAIDU_PROSIGN\":null,\"POPULATION_AGE\":31,\"USER_APPREGID\":null,\"POPULATION_ALIPAY\":null,\"ENTERPRISEAPPROVERAGENCY\":null,\"USER_CREATETIME\":\"2020-05-19 07:17:32\",\"POPULATION_GZDW\":null,\"REGRANGE\":null,\"VALID_IDCARD\":null,\"ENTERPRISEAPPROVALDATE\":null,\"USER_THIRDID\":null,\"USER_PIN\":null,\"SWB_ISSM3\":null,\"LEGALPERSON_CITYCODE\":null,\"REGAUTHORITY\":null,\"IS_PERFECT\":null,\"INDUSTRY\":null,\"QY_TYPE\":null,\"USER_SYS\":1,\"ENTERPRISEREGISTERDATE\":null,\"LEGALPERSON_ZPROCODE\":null,\"AGENTCERTTYPE\":null,\"CHARITYORG\":null,\"LOGIN_TYPE\":\"12\",\"SFZ_VALIDYEAR\":null,\"USER_CREATEDATE\":\"2020-05-19\",\"LEGALPERSON_NJQX\":null,\"LEGAL_KEYID\":null,\"LEGALPERSON_JBREMAIL\":null,\"LEGALPERSON_GSZCH\":null,\"ENTERPRISEENDDATE\":null,\"CERT_YXJZ\":null},\"success\":true,\"INVOKELOG_BTIME\":\"2022-04-02 14:29:53\"}}\n";
        String substring = str.substring ( 5 );
        String substring1 = substring.substring (0, substring.length () - 2 );
        Map parse =(Map) JSON.parse ( substring1 );
        Map data =(Map) parse.get ( "data" );
        String user_idcard = data.get ( "USER_IDCARD" ).toString ();
        StringBuilder stringBuilder = new StringBuilder (user_idcard);
        stringBuilder.replace ( 2,16,"**************" );
        System.out.println (new StringBuilder (user_idcard).replace ( 2,16,"**************" ));
*/

        /*MyEnum enumByCode = MyEnum.getEnumByCode ( "10001" );
        if(enumByCode == MyEnum.LOG_IN){
            HashMap<String,Object> paramsMap = new HashMap<String,Object>();
            paramsMap.put("INVOKESERVICE_CODE","103");
            paramsMap.put("INVOKECALLER_CODE","2c9bbe697dd997e0017e094e5b4e04152c9bbe697dd997e0");
            paramsMap.put("TRUST_TICKET", "trustticket" );
            String POSTPARAM_JSON = JSON.toJSONString(paramsMap);
            HashMap<String,Object> clientParam = new HashMap<String,Object>();
            clientParam.put("POSTPARAM_JSON", POSTPARAM_JSON);
            System.out.println (clientParam.toString ());
        }*/
    }
}
