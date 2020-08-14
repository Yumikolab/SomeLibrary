package com.licheedev.base.core;

import android.app.Dialog;
import androidx.annotation.StringRes;

/**
 * 等待对话框接口
 */
public interface WaitingDialog {

    /**
     * 默认不可以取消
     */
    boolean DEFAULT_CANCELABLE = false;

    /**
     * 设置对话框文本
     *
     * @param resId
     * @return
     */
    WaitingDialog setMessage(@StringRes int resId);

    /**
     * 设置对话框文本
     *
     * @param message
     * @return
     */
    WaitingDialog setMessage(CharSequence message);

    /**
     * 设置隐藏Dialog
     *
     * @param flag
     * @return
     */
    WaitingDialog setCancelable(boolean flag);

    /**
     * 显示对话框
     */
    void show();

    /**
     * 是否正在显示
     *
     * @return
     */
    boolean isShowing();

    /**
     * 隐藏对话框
     */
    void dismiss();

    /**
     * 获取包含的Dialog对象
     *
     * @return
     */
    Dialog getDialog();
}
