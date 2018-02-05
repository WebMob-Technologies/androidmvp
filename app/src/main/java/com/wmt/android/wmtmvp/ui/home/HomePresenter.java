package com.wmt.android.wmtmvp.ui.home;

import com.wmt.android.wmtmvp.data.model.brand_list.BrandListModel;
import com.wmt.android.wmtmvp.network.Service;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by rutvik on 2/2/18.
 */

public class HomePresenter {

    private Service service;
    private HomeView homeView;
    CompositeDisposable compositeDisposable;

    public HomePresenter(Service service, HomeView homeView) {

        this.service = service;
        this.homeView = homeView;
        compositeDisposable = new CompositeDisposable();
    }

    void getCityList() {
        homeView.showWait();
        Disposable disposable = service.getBrandListDate(new Service.BrandListCallback() {
            @Override
            public void onSuccess(BrandListModel brandListModel) {
                homeView.removeWait();
                homeView.onBrandListDataSuccess(brandListModel);
            }

            @Override
            public void onError(Throwable throwable) {
                homeView.removeWait();
                homeView.onFailure(throwable.getLocalizedMessage());
            }
        });

        compositeDisposable.add(disposable);

    }

    public void onStop() {
        compositeDisposable.dispose();
    }
}
