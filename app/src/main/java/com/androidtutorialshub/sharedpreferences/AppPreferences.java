package com.androidtutorialshub.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by lalit vasan on 2/13/2018.
 */

public class AppPreferences {

    // shared preferences keys
    public static final String KEY_USER_NAME = "KEY_USER_NAME";
    public static final String KEY_USER_EMAIL = "KEY_USER_EMAIL";
    public static final String KEY_USER_PHONE = "KEY_USER_PHONE";
    public static final String KEY_USER_TYPE = "KEY_USER_TYPE";
    public static final String KEY_SAVE_USER = "KEY_SAVE_USER";

    private static final String PREFERENCES_NAME = "ANDROID_TUTORIALS_HUB_PREFERENCES";

    private SharedPreferences sharedPreferences;

    /**
     * constructor
     *
     * @param context
     */
    public AppPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    /**
     * method to set string prefs
     *
     * @param key
     * @param value
     */
    public void setStringPrefs(String key, String value) {
        Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * method to get string prefs
     *
     * @param key
     * @return
     */
    public String getStringPrefs(String key) {
        return sharedPreferences.getString(key, null);
    }

    /**
     * method to set int prefs
     *
     * @param key
     * @param value
     */
    public void setIntPrefs(String key, int value) {
        Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * method to get int prefs
     *
     * @param key
     * @return
     */
    public int getIntPrefs(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    /**
     * method to set boolean prefs
     *
     * @param key
     * @param value
     */
    public void setBooleanPrefs(String key, boolean value) {
        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * method to get boolean prefs
     *
     * @param key
     * @return
     */
    public boolean getBooleanPrefs(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * method to set long prefs
     *
     * @param key
     * @param value
     */
    public void setLongPrefs(String key, long value) {
        Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * method to get long prefs
     *
     * @param key
     * @return
     */
    public long getLongPrefs(String key) {
        return sharedPreferences.getLong(key, 0L);
    }

    /**
     * method to set float prefs
     *
     * @param key
     * @param value
     */
    public void setFloatPrefs(String key, float value) {
        Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * method to get float prefs
     *
     * @param key
     * @return
     */
    public float getFloatPrefs(String key) {
        return sharedPreferences.getFloat(key, 0.0F);
    }

    /**
     * method to clear specific prefs
     *
     * @param key
     */
    public void clearPrefs(String key) {
        Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * method to clear all prefs
     */
    public void clearPrefs() {
        Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
