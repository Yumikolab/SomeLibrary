package com.licheedev.rateview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RateFrameLayout extends FrameLayout {

    private RateConfig mRateConfig = new RateConfig();

    public RateFrameLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RateFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RateFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RateFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.RateFrameLayout);

            float widthRate = typedArray.getFloat(R.styleable.RateFrameLayout_width_rate, 0);

            float heightRate = typedArray.getFloat(R.styleable.RateFrameLayout_height_rate, 0);

            boolean accordingWidth =
                typedArray.getBoolean(R.styleable.RateFrameLayout_according_width, true);

            // 初始化比例配置
            mRateConfig.init(widthRate, heightRate, accordingWidth);

            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mRateConfig.calMeasureSpec(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(mRateConfig.widthMeasureSpec, mRateConfig.heightMeasureSpec);
    }
}
