package com.licheedev.rxjava3ex;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

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
