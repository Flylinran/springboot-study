package cn.flylinran.utils;

import java.util.UUID;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description: UID工具类
 */
public final class UIDUtil {

    private static final String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    private UIDUtil() {
    }

    public static String generateUid32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateUid8() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = generateUid32();
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            stringBuilder.append(chars[x % 0x3E]);
        }
        return stringBuilder.toString();
    }

}
