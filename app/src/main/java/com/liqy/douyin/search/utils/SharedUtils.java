package com.liqy.douyin.search.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */

public class SharedUtils {
    private static final String FILE_NAME = "happuAcount";
    private static final String MODE_NAME ="welcome";

    //获取boolean类型值
    public static boolean getWelcomeBooleam(Context context){
        return  context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE)
                .getBoolean(MODE_NAME,false);//getBoolean的第二个参数为默认值，这里先传入false，然后在第二次启动时用putboolean将值覆盖为true
    }
    //写入boolean类型的值
    public static void putWelcomeBooleam(Context context,boolean isFirst){
        @SuppressLint("WrongConstant") SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME,Context.MODE_APPEND)
                .edit();
        editor.putBoolean(MODE_NAME,isFirst);
        editor.commit();
    }
}
