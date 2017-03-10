package com.phoenix.headlineview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 仿头条的适配器
 * Created by Phoenix on 2017/3/9.
 */

public abstract class PhoFlipperAdapter<M> {
    protected Context mContext;
    protected int mItemLayoutId;
    private List<M> mData;
    private HeadLineView mHeadLineView;

    public PhoFlipperAdapter(Context context, int itemLayoutId) {
        mContext = context;
        mItemLayoutId = itemLayoutId;
        mData = new ArrayList<>();
    }

    protected abstract void fillData(FlipperHelper helper, int position, M model);

    public void setData(List<M> datas) {
        mData = datas;
        init();
    }

    public List<M> getData() {
        return mData;
    }

    public void setHeadLineView(HeadLineView headLineView) {
        mHeadLineView = headLineView;
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        for (int i = 0; i < mData.size(); i++) {
            View view = inflater.inflate(mItemLayoutId, mHeadLineView, false);
            FlipperHelper mFlipperHelper = new FlipperHelper(view);
            fillData(mFlipperHelper, i, mData.get(i));
            mHeadLineView.addView(view);
        }
    }

    public void start() {
        mHeadLineView.startFlipping();
    }

    public void stop() {
        mHeadLineView.stopFlipping();
    }
}
