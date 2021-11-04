package com.geeker.love.utils;

import java.text.SimpleDateFormat;

public class FormatTimeUtils {
    public static String format(Long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(time);
    }

    public static Long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
