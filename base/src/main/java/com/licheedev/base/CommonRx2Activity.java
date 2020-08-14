package com.licheedev.base;

import android.app.Activity;
import android.content.Intent;
import com.licheedev.base.core.BindEventBus;
import com.licheedev.base.core.Rx2ActivityView;
import com.licheedev.base.core.WaitingDialog;
import com.licheedev.myutils.LogPlus;
import com.licheedev.myutils.ui.SystemUi;
import com.licheedev.myutils.ui.ToastUtil;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import org.greenrobot.eventbus.EventBus;

/**
 * 基础Activity，建议继承此类再写一个BaseActivity
 */
public abstract class CommonRx2Activity extends RxAppCompatActivity implements Rx2ActivityView {

    private WaitingDialog mWaitingDialog;


    /**
     * 5.0系统以上设置状态栏沉浸和透明
     */
    protected void setTranslucentStatus() {
        SystemUi.setTranslucentStatus(this);
    }

    /**
     * 需要注册EventBus
     *
     * @return
     */
    protected boolean toRegisterEventBus() {
        return this.getClass().isAnnotationPresent(BindEventBus.class);
    }

    /**
     * 注册EventBus
     */
    public void registerEventBus() {
        try {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        } catch (Exception e) {
            LogPlus.e(e.getMessage());
        }
    }

    /**
     * 反注册EventBus
     */
    public void unregisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    public void startActivityForResult(Class<? extends Activity> cls, int requestCode) {
        startActivityForResult(new Intent(this, cls), requestCode);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void showToast(int resId) {
        ToastUtil.show(this, resId);
    }

    @Override
    public void showToast(String text) {
        ToastUtil.show(this, text);
    }

    @Override
    public void showOneToast(int resId) {
        ToastUtil.showOne(this, resId);
    }

    @Override
    public void showOneToast(String text) {
        ToastUtil.showOne(this, text);
    }

    /**
     * 获取等待对话框实例，可以重写这个方法以实现自己的等待对话框
     *
     * @return
     */
    protected WaitingDialog getWaitingDialogInstance() {
        return new DefaultWaitingDialog(this);
    }

    @Override
    public void showWaitingDialog(String text, boolean cancelable) {
        if (mWaitingDialog == null) {
            mWaitingDialog = getWaitingDialogInstance();
        }

        mWaitingDialog.setMessage(text).setCancelable(cancelable);

        if (!mWaitingDialog.isShowing()) {
            mWaitingDialog.show();
        }
    }

    @Override
    public void showWaitingDialog(int stringRes, boolean cancelable) {
        showWaitingDialog(getString(stringRes), cancelable);
    }

    @Override
    public void showWaitingDialog(String text) {
        showWaitingDialog(text, WaitingDialog.DEFAULT_CANCELABLE);

    }

    @Override
    public void showWaitingDialog(int stringRes) {
        showWaitingDialog(getString(stringRes));
    }

    @Override
    public void dismissWaitingDialog() {
        try {
            if (mWaitingDialog != null && mWaitingDialog.isShowing()) {
                mWaitingDialog.dismiss();
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
