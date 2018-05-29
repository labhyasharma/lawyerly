package com.studiographene.lawyerly.basecode.di.components;


import com.studiographene.lawyerly.Dashboard.DashboardActivity;
import com.studiographene.lawyerly.basecode.common.BaseFragment;
import com.studiographene.lawyerly.basecode.di.modules.MyModule;
import com.studiographene.lawyerly.lawyerslist.LawyersListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {

//    void inject(ContactListFragment contactListFragment);
    void inject(BaseFragment baseFragment);
    void inject(DashboardActivity dashboardActivity);
    void inject(LawyersListFragment lawyersListFragment);
//    void inject(MsgDetailsListFragment msgDetailsListFragment);

}