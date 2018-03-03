package com.gjj.gd.materialdesign_v7.util;

import android.nfc.Tag;
import android.util.Log;

/**
 * Created by gaojuanjuan on 2018/3/4.
 */

public class Logger {
    public static final String TAG = "gjj";
    public static void i(String content){
        Log.i(TAG,content);
    }
    public static void d(String content){
        Log.d(TAG,content);
    }
    public static void e(String content){
        Log.e(TAG,content);
    }


}
