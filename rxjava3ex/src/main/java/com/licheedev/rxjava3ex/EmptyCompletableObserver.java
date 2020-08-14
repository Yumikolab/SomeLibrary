package com.licheedev.rxjava3ex;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

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
