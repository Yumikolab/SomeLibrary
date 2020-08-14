package com.licheedev.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.licheedev.base.core.BindEventBus;
import com.licheedev.base.core.Rx3FragmentView;
import com.licheedev.base.core.UiView;
import com.licheedev.myutils.LogPlus;
import com.trello.rxlifecycle4.components.support.RxFragment;
import org.greenrobot.eventbus.EventBus;

/**
 * 基础Fragment，建议继承此类再写一个BaseFragment
 */
public abstract class CommonRx3Fragment extends RxFragment implements Rx3FragmentView {

    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        unregisterEventBus();
        super.onDestroyView();
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
    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(getActivity(), cls));
    }

    @Override
    public void startActivityForResult(Class<? extends Activity> cls, int requestCode) {
        startActivityForResult(new Intent(getActivity(), cls), requestCode);
    }

    @Override
    public void finishActivity() {
        try {
            getActivityView().finishActivity();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showToast(int resId) {
        try {
            getActivityView().showToast(resId);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showToast(String text) {
        try {
            getActivityView().showToast(text);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showOneToast(int resId) {
        try {
            getActivityView().showOneToast(resId);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showOneToast(String text) {
        try {
            getActivityView().showOneToast(text);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showWaitingDialog(String text, boolean cancelable) {
        try {
            getActivityView().showWaitingDialog(text, cancelable);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showWaitingDialog(int stringRes, boolean cancelable) {
        try {
            getActivityView().showWaitingDialog(stringRes, cancelable);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showWaitingDialog(String text) {
        try {
            getActivityView().showWaitingDialog(text);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void showWaitingDialog(int stringRes) {
        try {
            getActivityView().showWaitingDialog(stringRes);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void dismissWaitingDialog() {
        try {
            getActivityView().dismissWaitingDialog();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    private UiView getActivityView() {
        return (UiView) mActivity;
    }
}
