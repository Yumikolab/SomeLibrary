package com.licheedev.rxjava2ex;

import androidx.annotation.NonNull;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 没有做任何处理的Observer
 */

public class EmptyObserver implements Observer<Object> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(@NonNull Object o) {

    }
}
