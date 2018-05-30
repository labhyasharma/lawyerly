package com.studiographene.lawyerly.Dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.studiographene.lawyerly.basecode.Application;
import com.studiographene.lawyerly.basecode.common.BaseFragment;
import com.studiographene.lawyerly.databinding.FragmentBottomBarBinding;

import javax.inject.Inject;


public class BottomBarFragment extends BaseFragment {

    private final String TAG = this.getClass().getSimpleName();

    FragmentBottomBarBinding binding;





    public static BottomBarFragment getInstance(Bundle bundle) {
        BottomBarFragment fragment = new BottomBarFragment();

        if (bundle == null) {
            bundle = new Bundle();
        }

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBottomBarBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    public void refresh() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Application) getActivity().getApplication()).getNetComponent().inject(this);
    }

    @Override
    public void postErrorHandling() {

    }

    @Override
    public View getLoader() {
        return null;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void close() {

        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }


}




