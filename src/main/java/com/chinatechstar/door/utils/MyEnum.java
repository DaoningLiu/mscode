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
    PRIVATES_KEY( "3", "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMknn6ZERGiH2xqL5EHfjUOJi90AAj/42V3r/Jpn04+PcC1M7HhBYu1OPsIwll1IBcjZffDrhntAtgbKRBvAreMhyjKnA3ZvOjvje1Z7z40ejNds49ivxYQHDxjiTH4GmolokHJRr/zEunxmvK4gBiZjSXMztaUuGfznMaeelCw7AgMBAAECgYAb8j5S6i8a2q0NDhxjLnzAwk5FIOgvHRKN4uhQR1Z0Hnh2QrajqmnlEDbV4cwyH3x2QAkoPICNhRsE7Hrz5BwEMBG8gR3et7eTOEioTKGgNCqqNLS3TNbTHTcov3kBbXr0lw3DybTYhEh73jVt6nBgVYVsVgptxaSjHn+9GyQfaQJBAPHk8j4HhllW0BiSGFWVZa/YzwVFBmEb2/EbAivKSRPdtUlZ5/BWxe3O3GOwQXfv8wREHjRjuipanK5K1tq6Y7cCQQDU4oIYHFxYZ1EkaLv9hEYHaD+kop33jfaV7oXPrgPX4CtBI7wwdt7qdhgbFGfvzbHerRtRSTULC9v1dE70dSOdAkEA6NJrEqcdecnkG3Iqt91G9Z0hjTnlrPwqkwNi8JEQC23++m3tn1d1xLGxUMYqDW3HoxiJVfWTDwcN/XgNGpQCOwJBAKmt0Jt/H2unDdnDUPOEVnzY7sE+jEIgeQaQEz+xJ4cNOey1mu3WEV83uYb8AMv2W2ts9nUXsJuZXDyL89KM+1ECQBWacpGfqIvsmx+eimDEpg3nz8wBuuTqaFClN1T3i/X/oBWAIpq8q1+jGrbhfwyAZIRTtiklMnDeEuMmlxbphkU=" ),
    PUVBLICS_KEY( "4", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJJ5+mRERoh9sai+RB341DiYvdAAI/+Nld6/yaZ9OPj3AtTOx4QWLtTj7CMJZdSAXI2X3w64Z7QLYGykQbwK3jIcoypwN2bzo743tWe8+NHozXbOPYr8WEBw8Y4kx+BpqJaJByUa/8xLp8ZryuIAYmY0lzM7WlLhn85zGnnpQsOwIDAQAB" ),
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