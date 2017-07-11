package com.filter;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class FilterUtil {

    public static String strFilter(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }


    public static String strFilter(String split, String... strs) {

        int newSize = 0;
        StringBuffer buffer = new StringBuffer();

        //先过滤掉 strs 数组中 为空的 字段
        for (int i = 0; i < strs.length; i++) {
            if (!TextUtils.isEmpty(strs[i])) {
                newSize++;//便利 查找非空长度
            }
        }
        String[] newStrs = new String[newSize];
        newSize = 0;

        for (int i = 0; i < strs.length; i++) {
            if (!TextUtils.isEmpty(strs[i])) {
                newStrs[newSize] = strs[i];
                newSize++;//便利 查找非空长度
            }
        }


        for (int i = 0; i < newStrs.length; i++) {
            if (i == 0) {
                buffer.append(newStrs[i]);
            } else {
                buffer.append(" " + split + " " + newStrs[i]);
            }
        }

//        for (String str : strs) {
//            if (!TextUtils.isEmpty(str)) {
//                buffer.append(str);
//                buffer.append(split);
//            }
//        }

        return buffer.toString();
    }


}
