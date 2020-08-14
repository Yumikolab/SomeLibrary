package com.licheedev.rxjava2ex;

import androidx.annotation.NonNull;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 没有做任何处理的EmptySingleObserver
 */

public class EmptySingleObserver<T> implements SingleObserver<T> {
    
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onSuccess(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
