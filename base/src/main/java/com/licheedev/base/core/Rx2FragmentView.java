package com.licheedev.base.core;

import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle3.android.FragmentEvent;

/**
 * Created by John on 2017/8/28.
 */

public interface Rx2FragmentView extends UiView, LifecycleProvider<FragmentEvent> {

}
