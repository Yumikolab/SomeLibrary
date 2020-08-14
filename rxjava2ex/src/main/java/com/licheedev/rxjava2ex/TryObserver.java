package com.licheedev.rxjava2ex;

import androidx.annotation.NonNull;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 就剩下try catch了onNext的Observer
 */
public abstract class TryObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        try {
            tryOnNext(t);
        } catch (Throwable tr) {
            onError(tr);
        }
    }

    protected abstract void tryOnNext(@NonNull T t);

    @Override
    public void onComplete() {

    }
}
