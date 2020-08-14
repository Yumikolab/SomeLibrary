package com.licheedev.rateview;

import android.view.View.MeasureSpec;

public class RateConfig {

    private float rate = 0;
    private boolean accordingWidth;
    public int widthMeasureSpec;
    public int heightMeasureSpec;

    public void init(float widthRate, float heightRate, boolean accordingWidth) {

        if (widthRate > 0 && heightRate > 0) {
            if (accordingWidth) {
                this.rate = heightRate / widthRate;
            } else {
                this.rate = widthRate / heightRate;
            }
        } else {
            this.rate = 0;
        }
        this.accordingWidth = accordingWidth;
    }

    public void calMeasureSpec(int widthMeasureSpec, int heightMeasureSpec) {
        if (rate > 0) {
            if (accordingWidth) {
                int specMode = MeasureSpec.getMode(widthMeasureSpec);
                int heightSize = (int) (MeasureSpec.getSize(widthMeasureSpec) * rate);
                this.widthMeasureSpec = widthMeasureSpec;
                this.heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, specMode);
            } else {
                int specMode = MeasureSpec.getMode(heightMeasureSpec);
                int widthSize = (int) (MeasureSpec.getSize(heightMeasureSpec) * rate);
                this.widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, specMode);
                this.heightMeasureSpec = heightMeasureSpec;
            }
        } else {
            this.widthMeasureSpec = widthMeasureSpec;
            this.heightMeasureSpec = heightMeasureSpec;
        }
    }
}
