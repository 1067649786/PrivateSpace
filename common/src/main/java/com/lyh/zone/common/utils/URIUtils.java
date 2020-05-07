package com.lyh.zone.common.utils;

public class URIUtils {
    /**
     * copy from web
     * URI匹配 支持 * 通配
     *
     * @param reg
     * @param input
     * @return
     */
    public static boolean matching(String reg, String input) {
        if ("/*".equals(reg)) {
            return true;
        }
        //按 * 切割字符串
        String[] reg_split = reg.split("\\*");
        int index = 0, reg_len = reg_split.length;
        //最后一个字符是否是 '*'
        boolean lastCharIsStar = reg.charAt(reg.length() - 1) == '*';
        while (input.length() > 0) {
            //匹配到最后一段
            if (index == reg_len) {
                return lastCharIsStar;
            }
            String r = reg_split[index++];
            int indexOf = input.indexOf(r);
            if (indexOf == -1) {
                return false;
            }
            //前面匹配成功的就可以不用管了,截取掉直接从新地方开始
            input = input.substring(indexOf + r.length());
        }
        return true;
    }
}

