package com.licheedev.myutils.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.licheedev.context.AppProvider;

/**
 * 屏幕尺寸工具类
 */
public class ScreenSize {

    private final Point mPoint = new Point();

    public ScreenSize(Context context) {
        updateRealSize(context.getApplicationContext());
    }

    private static class InstanceHolder {
        public static final ScreenSize inst = new ScreenSize(AppProvider.INSTANCE.getApplication());
    }

    public static ScreenSize get() {
        return InstanceHolder.inst;
    }

    private void updateRealSize(Context context) {

        WindowManager windowManager =
            (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        Display display = windowManager.getDefaultDisplay();

        try {
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB_MR2) {
                int width = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                int height = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
                mPoint.set(width, height);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {

                Display.class.getMethod("getRealSize", Point.class).invoke(display, mPoint);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                display.getRealSize(mPoint);
            } else {
                display.getSize(mPoint);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            display.getSize(mPoint);
        }

        // 判断宽度是不是比高度长
        if (mPoint.x > mPoint.y) {
            mPoint.set(mPoint.y, mPoint.x);
        }
    }

    /**
     * 获取屏幕真正的尺寸
     *
     * @return
     */
    public Point getRealSize() {
        return mPoint;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public int getRealWidth() {
        return mPoint.x;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public int getRealHeight() {
        return mPoint.y;
    }

    /**
     * 获取宽高比
     *
     * @return
     */
    public float getXYScale() {
        return mPoint.x / (float) mPoint.y;
    }

    /**
     * 获取进行宽高比缩放后的宽度
     *
     * @param height
     * @return
     */
    public int getScaleWidth(int height) {
        return (int) (height * mPoint.x / (float) mPoint.y);
    }

    /**
     * 获取进行宽高比缩放后的高度
     *
     * @param width
     * @return
     */
    public int getScaleHeight(int width) {
        return (int) (width * mPoint.y / (float) mPoint.x);
    }
}
