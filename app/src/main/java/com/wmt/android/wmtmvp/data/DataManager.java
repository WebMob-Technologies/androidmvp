package com.wmt.android.wmtmvp.data;

import android.content.Context;
import android.content.res.Resources;


import com.wmt.android.wmtmvp.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }
}
