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
import android.widget.RelativeLayout;

public class RateRelativeLayout extends RelativeLayout {

    private RateConfig mRateConfig = new RateConfig();

    public RateRelativeLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RateRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RateRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RateRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.RateRelativeLayout);

            float widthRate = typedArray.getFloat(R.styleable.RateRelativeLayout_width_rate, 0);

            float heightRate = typedArray.getFloat(R.styleable.RateRelativeLayout_height_rate, 0);

            boolean accordingWidth =
                typedArray.getBoolean(R.styleable.RateRelativeLayout_according_width, true);

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
