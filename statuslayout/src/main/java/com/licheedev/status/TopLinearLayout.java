package com.licheedev.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by John on 2017/10/9.
 */

public class TopLinearLayout extends LinearLayout {

    private int mNewHeightSpec;
    private StatusHeight mStatusHeight;

    public TopLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    public TopLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mStatusHeight = new StatusHeight(context);

        setOrientation(VERTICAL);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopLinearLayout);
        mStatusHeight.setFitStatusBar(
            ta.getBoolean(R.styleable.TopLinearLayout_fitStatusBar, true));
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
