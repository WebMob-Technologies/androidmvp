package com.wmt.android.wmtmvp.network;

import com.wmt.android.wmtmvp.data.model.brand_list.BrandListModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("demo/androidApi/list_rand.php")
    Observable<BrandListModel> getBrandList();
}