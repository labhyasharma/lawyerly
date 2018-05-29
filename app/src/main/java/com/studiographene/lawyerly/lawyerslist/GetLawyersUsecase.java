package com.studiographene.lawyerly.lawyerslist;


import com.studiographene.lawyerly.basecode.common.UsecaseBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetLawyersUsecase extends UsecaseBase<List<Lawyer>> {

    private final String TAG = this.getClass().getSimpleName();

    List<Lawyer> lawyerList;

    @Inject
    public GetLawyersUsecase() {

        lawyerList = new ArrayList<>();

    }


    @Override
    public Observable<List<Lawyer>> buildObservable() {

        lawyerList.add(new Lawyer("Ashu Saini","Crime","24","4.2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxkgRYdr1KI0Zy9br6iFhBZT2l_F0ZcGj-tXk2rgLrbg3D_GUW", true));
        lawyerList.add(new Lawyer("Labhya Sharma","Crime","24","4.2","https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg-1024x683.jpg", false));
        lawyerList.add(new Lawyer("Vishal Gupta","Crime","24","4.2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxkgRYdr1KI0Zy9br6iFhBZT2l_F0ZcGj-tXk2rgLrbg3D_GUW", true));
        lawyerList.add(new Lawyer("Salma Arsh","Crime","24","4.2","https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg-1024x683.jpg", true));
        lawyerList.add(new Lawyer("Vaibhav","Crime","24","4.2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxkgRYdr1KI0Zy9br6iFhBZT2l_F0ZcGj-tXk2rgLrbg3D_GUW",true));
        lawyerList.add(new Lawyer("Saurabh Singh","Crime","24","4.2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxkgRYdr1KI0Zy9br6iFhBZT2l_F0ZcGj-tXk2rgLrbg3D_GUW",false));
        lawyerList.add(new Lawyer("Ashu Saini","Crime","24","4.2","https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg-1024x683.jpg",false));
        lawyerList.add(new Lawyer("Ashu Saini","Crime","24","4.2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxkgRYdr1KI0Zy9br6iFhBZT2l_F0ZcGj-tXk2rgLrbg3D_GUW",true));
        lawyerList.add(new Lawyer("Ashu Saini","Crime","24","4.2","https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg-1024x683.jpg",true));

        return Observable.just(lawyerList);
    }



}