package com.licheedev.base.core;

import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle3.android.ActivityEvent;

/**
 * Created by John on 2017/8/28.
 */

public interface Rx2ActivityView extends UiView, LifecycleProvider<ActivityEvent> {

}
