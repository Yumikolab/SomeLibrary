package com.licheedev.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by John on 2017/10/9.
 */

public class TopRelativeLayout extends RelativeLayout {

    private int mNewHeightSpec;
    private StatusHeight mStatusHeight;

    public TopRelativeLayout(@NonNull Context context) {
        this(context, null);
    }

    public TopRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mStatusHeight = new StatusHeight(context);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopRelativeLayout);
        mStatusHeight.setFitStatusBar(
            ta.getBoolean(R.styleable.TopRelativeLayout_fitStatusBar, true));
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
