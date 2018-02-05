package com.wmt.android.wmtmvp.ui.home;

import com.wmt.android.wmtmvp.data.model.brand_list.BrandListModel;

/**
 * Created by rutvik on 2/2/18.
 */

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String failureMessage);

    void onBrandListDataSuccess(BrandListModel brandListModel);

}
