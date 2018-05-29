package com.studiographene.lawyerly.lawyerslist;


import com.studiographene.lawyerly.basecode.common.BasePresenter;
import com.studiographene.lawyerly.basecode.common.BaseView;

import java.util.List;

public interface LawyersListContract {

    public interface View extends BaseView {

        void refreshList(List<Lawyer> lawyers);
    }

    interface Presenter extends BasePresenter {

        void getLawyerList();
    }
}