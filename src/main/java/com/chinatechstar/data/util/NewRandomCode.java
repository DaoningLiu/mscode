package com.chinatechstar.data.util;

public class NewRandomCode {

    /**
     * 根据需要生成指定长度的纯数字随机数,这个随机数的每一位都是从(0-9)这个产生的一位
     * @param
     * @return
     */
    public static String getNewRandomCode(int codeLen) {
        java.util.Random randomCode = new java.util.Random();
        String strCode = "";
        while (codeLen > 0) {
            int charCode = randomCode.nextInt(9);
            strCode += charCode;
            codeLen--;
        }
        return strCode;
    }

}
