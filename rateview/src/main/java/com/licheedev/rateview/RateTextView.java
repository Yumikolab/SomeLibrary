package com.licheedev.rateview;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

public class RateTextView extends androidx.appcompat.widget.AppCompatTextView {

    private RateConfig mRateConfig = new RateConfig();
    
    public RateTextView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RateTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RateTextView(@NonNull Context context, @Nullable AttributeSet attrs,
        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RateTextView);

            float widthRate = typedArray.getFloat(R.styleable.RateTextView_width_rate, 0);

            float heightRate = typedArray.getFloat(R.styleable.RateTextView_height_rate, 0);

            boolean accordingWidth = typedArray.getBoolean(R.styleable.RateTextView_according_width, true);

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
