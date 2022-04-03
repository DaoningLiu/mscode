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