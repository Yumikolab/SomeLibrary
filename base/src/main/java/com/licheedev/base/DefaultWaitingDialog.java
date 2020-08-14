package com.licheedev.base;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StyleRes;
import com.licheedev.base.core.WaitingDialog;

/**
 * 默认的等待对话框
 */
public class DefaultWaitingDialog implements WaitingDialog {

    private final TextView tvMessage;
    private final Dialog dialog;

    public DefaultWaitingDialog(Context context) {
        this(context, R.layout.dialog_waiting);
    }

    public DefaultWaitingDialog(Context context, @LayoutRes int customLayout) {
        this(context, customLayout, R.id.tvWaitingMessage);
    }

    public DefaultWaitingDialog(Context context, @LayoutRes int customLayout,
        @IdRes int messageId) {
        this(context, R.style.WaitingDialogStyle, customLayout, messageId);
    }

    public DefaultWaitingDialog(Context context, @StyleRes int themeResId,
        @LayoutRes int customLayout, @IdRes int messageId) {
        dialog = new Dialog(context, themeResId);
        dialog.setContentView(customLayout);
        tvMessage = dialog.findViewById(messageId);
    }

    @Override
    public WaitingDialog setMessage(int resId) {
        tvMessage.setText(resId);
        return this;
    }

    @Override
    public WaitingDialog setMessage(CharSequence message) {
        tvMessage.setText(message);
        return this;
    }

    @Override
    public WaitingDialog setCancelable(boolean flag) {
        dialog.setCancelable(flag);
        return this;
    }

    @Override
    public void show() {
        dialog.show();
    }

    @Override
    public boolean isShowing() {
        return dialog.isShowing();
    }

    @Override
    public void dismiss() {
        dialog.dismiss();
    }

    @Override
    public Dialog getDialog() {
        return dialog;
    }
}
