package com.wmt.android.wmtmvp;

import android.app.Application;
import android.content.Context;

import com.wmt.android.wmtmvp.di.component.ApplicationComponent;
import com.wmt.android.wmtmvp.di.component.DaggerApplicationComponent;
import com.wmt.android.wmtmvp.di.module.ApplicationModule;
import com.wmt.android.wmtmvp.di.module.RetrofitModule;


/**
 * Created by rutvik on 31/1/18.
 */

public class WmtMVP extends Application {
    ApplicationComponent applicationComponent;
    public static final String BASE_URL = "http://appsdata2.cloudapp.net/";

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitModule(new RetrofitModule(BASE_URL))
                .build();

    }

    public static WmtMVP get(Context context) {
        return (WmtMVP) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
