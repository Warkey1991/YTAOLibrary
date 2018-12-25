package com.ytlibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ytao on 2018/11/21
 * Describe: 基本功能库
 */
public class BaseFunction {
    private static Context context;

    public BaseFunction(Context mContext) {
        context = mContext;
    }

    /**
     * 弹出Toast消息
     * @param message
     */
    public static void showToast(String message){
        Toast.makeText(context, message , Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出Toast消息
     * @param message
     * @param time 消息存在时间
     */
    public static void showToast(String message, int time) {
        Toast.makeText(context, message, time).show();
    }

}
