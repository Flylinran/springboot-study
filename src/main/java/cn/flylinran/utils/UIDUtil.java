package cn.flylinran.utils;

import java.util.UUID;

/**
 * UUID生成工具
 */
public class UIDUtil {

    public static String getRandomUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
