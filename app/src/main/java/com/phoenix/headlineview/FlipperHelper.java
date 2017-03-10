package com.phoenix.headlineview;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;

/**
 * 帮助类
 * Created by Phoenix on 2017/3/9.
 */

public class FlipperHelper {
    private SparseArray<View> mViews;
    private View mContentView;

    public FlipperHelper(View convertView) {
        mViews = new SparseArray<>();
        mContentView = convertView;
    }

    public View getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }
}
