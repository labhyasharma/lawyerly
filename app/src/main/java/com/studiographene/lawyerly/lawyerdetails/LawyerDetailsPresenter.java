package com.studiographene.lawyerly.lawyerdetails;


import com.studiographene.lawyerly.basecode.common.BasePresenterImpl;
import com.studiographene.lawyerly.basecode.common.BaseView;

import javax.inject.Inject;


public class LawyerDetailsPresenter extends BasePresenterImpl implements LawyerDetailsContract.Presenter {

    private final String TAG = this.getClass().getSimpleName();
    LawyerDetailsContract.View view;


    @Inject
    LawyerDetailsPresenter() {


    }

    @Override
    public BaseView getView() {
        return view;
    }

    @Override
    public void attachView(BaseView v) {
        this.view = (LawyerDetailsContract.View) v;
    }
}
