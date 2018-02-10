package com.wmt.android.wmtmvp.network;


import android.app.Application;
import android.content.Context;

import com.wmt.android.wmtmvp.WmtMVP;
import com.wmt.android.wmtmvp.data.model.brand_list.BrandListModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

public class Service {
    private final ApiInterface networkService;

    @Inject
    Retrofit retrofit;

    @Inject
    Application application;



    public Service(ApiInterface networkService,Context context) {
        this.networkService = networkService;
        WmtMVP.get(context).getApplicationComponent().inject(this);
    }
    public Disposable getBrandListDate(final BrandListCallback callback){

        return retrofit.create(ApiInterface.class).getBrandList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends BrandListModel>>() {
                    @Override
                    public ObservableSource<? extends BrandListModel> apply(Throwable throwable) throws Exception {
                        callback.onError(throwable);
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Consumer<BrandListModel>() {

                    @Override
                    public void accept(BrandListModel brandListModel) throws Exception {
                        callback.onSuccess(brandListModel);
                    }
                });
    }

    public interface BrandListCallback{
        void onSuccess(BrandListModel brandListModel);
        void onError(Throwable throwable);
    }

  /*  public CompositeDisposable getRandomUserData(final ServiceCallback callback) {
       // Observable<ResponseBody> observable = null;
       *//* return retrofit.create(ApiInterface.class).getRandomUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends ResponseBody>>() {
                    @Override
                    public ObservableSource<? extends ResponseBody> apply(Throwable throwable) throws Exception {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        callback.onSuccess(responseBody);
                    }
                });*//*
        return null;

    }*/

  /*  public interface ServiceCallback {
        void onSuccess(ResponseBody cityListResponse);

        void onError(NetworkError networkError);
    }*/
}
