package com.licheedev.status;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/**
 * 状态栏高度工具类
 */
public class StatusHeight {

    private final int mHeight;
    private boolean mFitStatusBar;

    public StatusHeight(Context context) {
        this(context, false);
    }

    public StatusHeight(Context context, boolean fitStatusBar) {
        mHeight = getHeight(context);
        mFitStatusBar = fitStatusBar;
    }

    public int getHeight() {
        return mHeight;
    }

    /**
     * 是否适配状态栏
     *
     * @return
     */
    public boolean isFitStatusBar() {
        return mFitStatusBar;
    }

    /**
     * 设置适配状态栏
     *
     * @param fitStatusBar
     */
    public void setFitStatusBar(boolean fitStatusBar) {
        mFitStatusBar = fitStatusBar;
    }

    /**
     * 可以设置透明状态栏
     *
     * @return
     */
    public boolean canTranslucentStatus() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * 是否应该去适配状态栏
     *
     * @return
     */
    public boolean toFitStatusBar() {
        return isFitStatusBar() & canTranslucentStatus();
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getHeight(Context context) {
        int result = 0;
        try {
            Resources resources = context.getResources();
            int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                int sizeOne = context.getResources().getDimensionPixelSize(resourceId);
                int sizeTwo = Resources.getSystem().getDimensionPixelSize(resourceId);

                if (sizeTwo >= sizeOne) {
                    return sizeTwo;
                } else {
                    float densityOne = context.getResources().getDisplayMetrics().density;
                    float densityTwo = Resources.getSystem().getDisplayMetrics().density;
                    float f = sizeOne * densityTwo / densityOne;
                    return (int) ((f >= 0) ? (f + 0.5f) : (f - 0.5f));
                }
            }
        } catch (Resources.NotFoundException ignored) {
            return 0;
        }
        return result;
    }
}
