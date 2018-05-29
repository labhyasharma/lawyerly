package com.studiographene.lawyerly.basecode.common;

public interface BasePresenter {

    void attachView(BaseView v);
    void onError(Throwable e);
    void onDestroy();

}
