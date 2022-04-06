package com.chinatechstar.door.utils;

import javax.annotation.Nullable;

/**
 * 命名规范:
 * 枚举类名带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
 * 说明：枚举其实就是特殊的常量类，且构造方法被默认强制是私有。
 * 正例：枚举名字为 MyEnum 的成员名称：SUCCESS / UNKNOWN_REASON。
 *
 * @author peanut
 */
public enum MyEnum {
    //  三、枚举成员
    SUCCESS ( "0000", "成功" ),
    ORGANI_ZATION ("1000","/public/service/queryOrg"),
    LOG_IN("10001","https://mztapp.fujian.gov.cn:8304/dataset/AppSerController/invokeservice.do"),
    FAILED ( "0001", "失败" ),
    PUVBLIC_KEY( "1", "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEIZR0oo9lbBUZ8U6MgWXV+xBdXoymSzzYHde+BDx+g2k2IcPjuuWZMhyesnVJK5c0HbUPTbm6tyWZdNZmFJ5xbg==" ),
    PRIVATE_KEY( "2", "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgN9SWEergph5xbGBsYKDSXWcNwh9PSQsLmlDWLyJQ54SgCgYIKoEcz1UBgi2hRANCAASC1R+xaxpSuZNINW1sEnf57uGzUmYVjYkpCThvxQgZ8l8Yn8UcrZ+vXvQaI04wegAelesu1w0RADMcuuPoB4Yn" ),
    PRIVATES_KEY( "3", "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgx++/lV/KJPzGBLlFUOq4yz3hJR5yzpISzAQCpISN3LmgCgYIKoEcz1UBgi2hRANCAARdI661jVmYtogy/ZwBash33812S+e21T2qeiWiLlsP/VZtZmWsZpF+xxsO6VRlfGTIQvZI/GQu1yyyP2YocdfT" ),
    PUVBLICS_KEY( "4", "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEXSOutY1ZmLaIMv2cAWrId9/NdkvnttU9qnoloi5bD/1WbWZlrGaRfscbDulUZXxkyEL2SPxkLtcssj9mKHHX0w==" ),
    ;

    //  四、常用工具类

    /**
     * 根据枚举的编码获得对应的枚举
     *
     * @param code
     * @return
     */
    public static MyEnum getEnumByCode(@Nullable String code) {
        if (code == null) {
            return null;
        }
        for (MyEnum value : MyEnum.values ()) {
            if (value.getCode ().equals ( code )) {
                return value;
            }
        }
        return null;
    }

    //  一、属性 (可根据需要自定义)
    /**
     * 枚举编码
     */
    private final String code;
    /**
     * 枚举描述
     */
    private final String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    //  二、构造方法
    MyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}