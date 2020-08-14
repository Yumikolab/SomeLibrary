package com.licheedev.rxjava3ex;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 就剩下onNext没实现的Observer
 */

public abstract class NextObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
