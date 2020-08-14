package com.licheedev.rxjava2ex;

import androidx.annotation.NonNull;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * 没有做任何处理的CompletableObserver
 */

public class EmptyCompletableObserver implements CompletableObserver {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
