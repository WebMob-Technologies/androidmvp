package com.wmt.android.wmtmvp.ui.home;

import com.wmt.android.wmtmvp.base.BaseRecyclerAdapter;
import com.wmt.android.wmtmvp.data.model.brand_list.BrandList;
import com.wmt.android.wmtmvp.viewholder.HomeViewHolder;

import java.util.List;

/**
 * Created by rutvik on 2/2/18.
 */

public class HomeAdapter extends BaseRecyclerAdapter<BrandList,HomeViewHolder> {


    HomeAdapter(Class<HomeViewHolder> viewHolderClass, int modelLayout) {
        super(viewHolderClass, modelLayout);
    }

    @Override
    protected void populateViewHolder(HomeViewHolder viewHolder, BrandList model, int position) {
        viewHolder.getTvName().setText(model.getName());
        viewHolder.getTvDesc().setText(model.getDescription());
        viewHolder.getTvDate().setText(model.getCreatedAt());
    }

    @Override
    public void setItems(List<BrandList> items) {
        super.setItems(items);
    }

    @Override
    public void clearItems() {
        super.clearItems();
    }

    @Override
    public void updateItem(BrandList brandList, int position) {
        super.updateItem(brandList, position);
    }


}
