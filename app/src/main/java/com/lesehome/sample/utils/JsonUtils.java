package com.lesehome.sample.utils;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by hcp on 16/1/18.
 */
public class JsonUtils {

    public static String toJson(Object json) {
        return new Gson().toJson(json);
    }

    /**
     * 把json字符串转化成Java bean对象
     *
     * @param jsonString
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(final String jsonString, final Class<T> classOfT) {
        try {
            return new Gson().fromJson(jsonString, classOfT);
        } catch (Exception e) {
            Log.e("JsonUtils-formJson", "json can not convert to " + classOfT.getName(), e);
            return null;
        }
    }

    /**
     * 把json字符串转化成Java bean对象
     *
     * @param jsonString
     * @param typeOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(final String jsonString, final Type typeOfT) {
        try {
            return new Gson().fromJson(jsonString, typeOfT);
        } catch (Exception e) {
            Log.e("JsonUtils-formJson", "json can not convert to " + typeOfT.getClass().getName(), e);
            return null;
        }
    }
}
