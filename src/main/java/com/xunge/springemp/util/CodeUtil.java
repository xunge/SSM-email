package com.xunge.springemp.util;

import java.util.UUID;

/**
 * Created by xunge on 2017/7/14.
 */
public class CodeUtil {
    //生成唯一的激活码
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
