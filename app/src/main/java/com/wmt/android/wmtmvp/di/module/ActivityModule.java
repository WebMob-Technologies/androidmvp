package com.wmt.android.wmtmvp.di.module;

import android.app.Activity;
import android.content.Context;


import com.wmt.android.wmtmvp.di.ActivityContext;
import com.wmt.android.wmtmvp.ui.home.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
