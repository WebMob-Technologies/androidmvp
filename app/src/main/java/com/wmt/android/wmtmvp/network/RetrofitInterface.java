package com.wmt.android.wmtmvp.network;

import android.os.Bundle;

import okhttp3.ResponseBody;

/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

public interface RetrofitInterface {
    void onResponse(ResponseBody response, int requestId, Bundle extra);

    void onError(Throwable error, int requestId, Bundle extra);
}
