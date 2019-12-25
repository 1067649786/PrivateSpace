package com.lyh.ps.common.utils;

import java.util.UUID;

public class UUIDUtils {

    /**
     * 生成UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 生成指定长度的UUID
     * @param len
     * @return
     */
    public static String getUUID(int len){
        if(len <= 0){
            return null;
        }
        String uuid=getUUID();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<len;i++){
            sb.append(uuid.charAt(i));
        }
        return sb.toString();
    }
}
