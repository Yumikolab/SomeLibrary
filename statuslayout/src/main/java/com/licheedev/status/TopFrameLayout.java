package com.licheedev.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 一个在原来定义的尺寸上，额外添加状态栏高度的FrameLayout
 * 如在xml中写死
 */
public class TopFrameLayout extends FrameLayout {

    private int mNewHeightSpec;

    private StatusHeight mStatusHeight;

    /**
     * 一个在原来定义的尺寸上，额外添加状态栏高度的FrameLayout
     *
     * @param context
     */
    public TopFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public TopFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mStatusHeight = new StatusHeight(context);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopFrameLayout);
        mStatusHeight.setFitStatusBar(
            ta.getBoolean(R.styleable.TopFrameLayout_fitStatusBar, true));
        ta.recycle();

        mNewHeightSpec = 0;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (mStatusHeight.toFitStatusBar() && mNewHeightSpec == 0) {

            int height = MeasureSpec.getSize(heightMeasureSpec) + mStatusHeight.getHeight();
            mNewHeightSpec =
                MeasureSpec.makeMeasureSpec(height, MeasureSpec.getMode(heightMeasureSpec));
        }

        if (mNewHeightSpec != 0) {
            super.onMeasure(widthMeasureSpec, mNewHeightSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
