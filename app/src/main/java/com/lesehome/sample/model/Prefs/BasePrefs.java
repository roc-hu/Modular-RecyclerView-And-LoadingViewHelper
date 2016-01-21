package com.lesehome.sample.model.Prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.Set;

/**
 * Created by hcp on 16/1/21.
 */
public abstract class BasePrefs {

    private static final String PREFS_NAME = "prefs_name";
    private static final String PREFS_VERSION_KEY = "version";
    private static final String VERSION_1 = "1.0";

    public SharedPreferences preferences;

    public BasePrefs(Context context, String prefsName) {
        this(context, prefsName, VERSION_1);
    }

    public BasePrefs(Context context, String prefsName, String version) {
        this.preferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        this.setVersion(version);
    }

    protected Set<String> getStringSet(String key, Set<String> defValues) {
        return preferences.getStringSet(key, defValues);
    }

    protected String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    protected float getFloat(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    protected int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    protected long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    protected boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    protected void setVersion(String version) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFS_VERSION_KEY, TextUtils.isEmpty(version)
                ? VERSION_1 : version).apply();
    }

    protected void putStringSet(String key, Set<String> values) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(key, values).apply();
    }

    protected void putString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value).apply();
    }

    protected void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value).apply();
    }

    protected void putFloat(String key, float value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value).apply();
    }

    protected void putLong(String key, long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value).apply();
    }

    protected void putInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value).apply();
    }

    protected void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();
    }

    protected void remove(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key).apply();
    }
}
