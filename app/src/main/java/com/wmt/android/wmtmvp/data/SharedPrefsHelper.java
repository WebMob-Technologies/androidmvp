package com.wmt.android.wmtmvp.data;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

@Singleton
public class SharedPrefsHelper {

    final static String PREF_KEY_ACCESS_TOKEN = "access-token";

    private SharedPreferences mSharedPreferences;

    @Inject
    Gson gson;

    @Inject
    SharedPrefsHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }
    public <T> void put(String key, Class<T> clazz, T input) {
       mSharedPreferences.edit().putString(key, gson.toJson(input)).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public  <T> T getModel(String key, Class<T> input){
        return gson.fromJson(mSharedPreferences.getString(key, ""), input);
    }


    public void deleteSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    public void clearAllDate(){
        mSharedPreferences.edit().clear().apply();
    }
}
