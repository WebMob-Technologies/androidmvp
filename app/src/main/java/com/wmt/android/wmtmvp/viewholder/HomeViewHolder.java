package com.wmt.android.wmtmvp.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.wmt.android.wmtmvp.R;
import com.wmt.android.wmtmvp.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by rutvik on 2/2/18.
 */

public class HomeViewHolder extends BaseViewHolder {

    @BindView(R.id.tvName)
    AppCompatTextView tvName;

    @BindView(R.id.tvDesc)
    AppCompatTextView tvDesc;

    @BindView(R.id.tvDate)
    AppCompatTextView tvDate;

    public HomeViewHolder(View itemView) {
        super(itemView);
    }

    public AppCompatTextView getTvName(){ return tvName; }

    public AppCompatTextView getTvDesc(){ return tvDesc; }

    public AppCompatTextView getTvDate(){ return tvDate; }
}
