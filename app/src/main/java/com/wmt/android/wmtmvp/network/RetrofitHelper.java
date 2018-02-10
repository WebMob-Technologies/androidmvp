package com.wmt.android.wmtmvp.network;

import android.os.Bundle;
import android.support.annotation.NonNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

public class RetrofitHelper {

    private Bundle mRequestExtra;
    private int mRequestId;
    private RetrofitInterface retrofitInterface;

    public static class Builder implements Callback {

        RetrofitHelper retrofitRequest;

        public Builder() {
            retrofitRequest = new RetrofitHelper();
        }

        public Builder setRequestId(int requestId) {
            retrofitRequest.mRequestId = requestId;
            return this;
        }

        public Builder setCallback(RetrofitInterface callback) {
            retrofitRequest.retrofitInterface = callback;
            return this;
        }

        public Builder setExtra(Bundle requestExtra) {
            retrofitRequest.mRequestExtra = requestExtra;
            return this;
        }


        @Override
        public void onResponse(Call call, Response response) {
            retrofitRequest.retrofitInterface.onResponse((ResponseBody) response.body(), retrofitRequest.mRequestId, retrofitRequest.mRequestExtra);
        }

        @Override
        public void onFailure(Call call, Throwable t) {
            retrofitRequest.retrofitInterface.onError(t, retrofitRequest.mRequestId, retrofitRequest.mRequestExtra);

        }
    }
}
