package com.lesehome.sample.model.Prefs;

import android.content.Context;

/**
 * Created by hcp on 16/1/21.
 */
public class SplashPrefs extends BasePrefs {

    public static final String KEY_ISFIRSTIN = "isFirstIn";

    public SplashPrefs(Context context) {
        super(context, SplashPrefs.class.getSimpleName());
    }

    /**
     * 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
     *
     * @return
     */
    public boolean isFirstIn() {
        return getBoolean(KEY_ISFIRSTIN, true);
    }

    /**
     * 设置已经引导过了，下次启动不用再次引导
     *
     * @return
     */
    public void setNotFirstIn() {
        putBoolean(KEY_ISFIRSTIN, false);
    }
}
