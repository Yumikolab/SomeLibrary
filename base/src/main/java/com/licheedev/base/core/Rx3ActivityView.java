package com.licheedev.base.core;

import com.trello.rxlifecycle4.LifecycleProvider;
import com.trello.rxlifecycle4.android.ActivityEvent;

/**
 * Created by John on 2017/8/28.
 */

public interface Rx3ActivityView extends UiView, LifecycleProvider<ActivityEvent> {

}
