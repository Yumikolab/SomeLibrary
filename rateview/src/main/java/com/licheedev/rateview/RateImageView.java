package com.licheedev.rateview;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

public class RateImageView extends androidx.appcompat.widget.AppCompatImageView {

    private RateConfig mRateConfig = new RateConfig();

    public RateImageView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RateImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RateImageView(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.RateImageView);

            float widthRate = typedArray.getFloat(R.styleable.RateImageView_width_rate, 0);

            float heightRate = typedArray.getFloat(R.styleable.RateImageView_height_rate, 0);

            boolean accordingWidth =
                typedArray.getBoolean(R.styleable.RateImageView_according_width, true);

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
