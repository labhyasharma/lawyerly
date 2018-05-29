package com.studiographene.lawyerly.basecode.common;

import io.reactivex.Observable;

public abstract class UsecaseBase<T> {

    public abstract Observable<T> buildObservable();

    public Observable<T> execute() {
        return buildObservable();
    }

}
