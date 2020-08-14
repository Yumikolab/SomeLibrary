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
import android.widget.LinearLayout;

public class RateLinearLayout extends LinearLayout {

    private RateConfig mRateConfig = new RateConfig();

    public RateLinearLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RateLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RateLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RateLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.RateLinearLayout);

            float widthRate = typedArray.getFloat(R.styleable.RateLinearLayout_width_rate, 0);

            float heightRate = typedArray.getFloat(R.styleable.RateLinearLayout_height_rate, 0);

            boolean accordingWidth =
                typedArray.getBoolean(R.styleable.RateLinearLayout_according_width, true);

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
