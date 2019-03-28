package com.licheedev.rateview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class RateImageButton extends android.support.v7.widget.AppCompatImageButton {

    private float rate;
    private boolean accordingWidth;

    public RateImageButton(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RateImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RateImageButton(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.RateImageButton);

            float widthRate = typedArray.getFloat(R.styleable.RateImageButton_width_rate, 0);

            float heightRate = typedArray.getFloat(R.styleable.RateImageButton_height_rate, 0);

            accordingWidth =
                typedArray.getBoolean(R.styleable.RateImageButton_according_width, true);

            if (widthRate > 0 && heightRate > 0) {

                if (accordingWidth) {
                    rate = heightRate / widthRate;
                } else {
                    rate = widthRate / heightRate;
                }
            } else {
                rate = 0;
            }
            typedArray.recycle();
        } else {
            rate = 0;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (rate > 0) {
            if (accordingWidth) {
                int specMode = MeasureSpec.getMode(widthMeasureSpec);
                int heightSize = (int) (MeasureSpec.getSize(widthMeasureSpec) * rate);
                int newHeightSpec = MeasureSpec.makeMeasureSpec(heightSize, specMode);
                super.onMeasure(widthMeasureSpec, newHeightSpec);
            } else {
                int specMode = MeasureSpec.getMode(heightMeasureSpec);
                int widthSize = (int) (MeasureSpec.getSize(heightMeasureSpec) * rate);
                int newWidthSpec = MeasureSpec.makeMeasureSpec(widthSize, specMode);
                super.onMeasure(newWidthSpec, heightMeasureSpec);
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
