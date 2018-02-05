package com.wmt.android.wmtmvp.di.component;

import android.app.Application;

import android.content.Context;


import com.wmt.android.wmtmvp.WmtMVP;
import com.wmt.android.wmtmvp.data.DataManager;
import com.wmt.android.wmtmvp.data.DbHelper;
import com.wmt.android.wmtmvp.data.SharedPrefsHelper;
import com.wmt.android.wmtmvp.di.ApplicationContext;
import com.wmt.android.wmtmvp.di.module.ActivityModule;
import com.wmt.android.wmtmvp.di.module.ApplicationModule;
import com.wmt.android.wmtmvp.di.module.RetrofitModule;
import com.wmt.android.wmtmvp.network.Service;
import com.wmt.android.wmtmvp.ui.home.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

@Singleton
@Component(modules = {ApplicationModule.class,RetrofitModule.class})

public interface ApplicationComponent {

    void inject(WmtMVP wmtMVP);

    void inject(Service service);

    void inject(HomeActivity activity);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

    Retrofit getRetrofit();
}
