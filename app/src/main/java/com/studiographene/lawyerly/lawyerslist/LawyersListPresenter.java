package com.studiographene.lawyerly.lawyerslist;


import com.studiographene.lawyerly.basecode.common.BasePresenterImpl;
import com.studiographene.lawyerly.basecode.common.BaseView;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by ashu on 11/03/17.
 */

public class LawyersListPresenter extends BasePresenterImpl implements LawyersListContract.Presenter {

    private final String TAG = this.getClass().getSimpleName();
    LawyersListContract.View view;

    GetLawyersUsecase usecase;

    @Inject
    LawyersListPresenter(GetLawyersUsecase usecase) {

        this.usecase = usecase;


    }

    @Override
    public BaseView getView() {
        return view;
    }

    @Override
    public void attachView(BaseView v) {
        this.view = (LawyersListContract.View) v;
    }

    @Override
    public void getLawyerList() {
        usecase.execute().subscribe(this::onSuccess,this::onError);
    }

    private void onSuccess(List<Lawyer> lawyers) {
        view.refreshList(lawyers);
    }
}
