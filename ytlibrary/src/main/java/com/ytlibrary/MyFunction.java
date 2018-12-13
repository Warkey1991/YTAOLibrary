package com.ytlibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ytao on 2018/11/21
 * Describe: 测试库
 */
public class MyFunction {

    public static void showToast(Context context, String message){
        Toast.makeText(context, message + "功能库测试", Toast.LENGTH_LONG).show();
    }

}
