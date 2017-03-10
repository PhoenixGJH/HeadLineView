package com.phoenix.headlineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

/**
 * 循环滚动
 * Created by Phoenix on 2017/3/9.
 */

public class HeadLineView extends ViewFlipper {
    private static final int INTERVAL = 2000;
    private static final int DURATION = 500;
    private int mInterval = INTERVAL;//翻页的间隔
    private int mAnimDruation = DURATION;//动画持续时间
    private Animation mAnimIn, mAnimOut;
    private int mAnimInRes = R.anim.bottom_in;
    private int mAnimOutRes = R.anim.top_out;

    public HeadLineView(Context context) {
        this(context, null);
    }

    public HeadLineView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeadLineView);
        mInterval = typedArray.getInt(R.styleable.HeadLineView_hl_interval, INTERVAL);
        mAnimInRes = typedArray.getResourceId(R.styleable.HeadLineView_hl_anim_in, mAnimInRes);
        mAnimOutRes = typedArray.getResourceId(R.styleable.HeadLineView_hl_anim_out, mAnimOutRes);

        //设置翻页的间隔
        setFlipInterval(mInterval);
        //设置进入动画
        mAnimIn = AnimationUtils.loadAnimation(context, mAnimInRes);
        mAnimIn.setDuration(mAnimDruation);
        setInAnimation(mAnimIn);
        //设置退出动画
        mAnimOut = AnimationUtils.loadAnimation(context, mAnimOutRes);
        mAnimOut.setDuration(mAnimDruation);
        setOutAnimation(mAnimOut);

        typedArray.recycle();
    }

    public void setAdapter(PhoFlipperAdapter adapter) {
        adapter.setHeadLineView(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }
}
