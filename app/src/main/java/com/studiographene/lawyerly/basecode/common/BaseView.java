package com.studiographene.lawyerly.basecode.common;

import android.view.View;

public interface BaseView {

    void showSnackBar(String s);
    void showProgressBar(Boolean b);
    void postErrorHandling();
    View getLoader();
    void refresh();
    void logout();

}
