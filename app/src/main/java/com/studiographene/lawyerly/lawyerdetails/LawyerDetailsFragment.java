package com.studiographene.lawyerly.lawyerdetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.studiographene.lawyerly.basecode.Application;
import com.studiographene.lawyerly.basecode.common.BaseFragment;
import com.studiographene.lawyerly.databinding.FragmentLawyerDetailsBinding;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.studiographene.lawyerly.lawyerslist.LawyersListFragment.NAME;
import static com.studiographene.lawyerly.lawyerslist.LawyersListFragment.PIC_URL;
import static com.studiographene.lawyerly.lawyerslist.LawyersListFragment.RATE;
import static com.studiographene.lawyerly.lawyerslist.LawyersListFragment.RATINGS;
import static com.studiographene.lawyerly.lawyerslist.LawyersListFragment.SPECIALITY;
import static com.studiographene.lawyerly.lawyerslist.LawyersListFragment.VERIFIED;


public class LawyerDetailsFragment extends BaseFragment implements LawyerDetailsContract.View {

    private final String TAG = this.getClass().getSimpleName();

    FragmentLawyerDetailsBinding binding;


    @Inject
    LawyerDetailsPresenter presenter;

    public static LawyerDetailsFragment getInstance(Bundle bundle) {
        LawyerDetailsFragment fragment = new LawyerDetailsFragment();

        if (bundle == null) {
            bundle = new Bundle();
        }

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLawyerDetailsBinding.inflate(inflater, container, false);

        presenter.attachView(this);


        makeUIChanges();


        return binding.getRoot();
    }


    void makeUIChanges(){
        if (getActivity().getIntent() != null)
        {
            Intent intent = getActivity().getIntent();

            String name = intent.getStringExtra(NAME);
            String speciality = intent.getStringExtra(SPECIALITY);
            String rate = intent.getStringExtra(RATE);
            String ratings = intent.getStringExtra(RATINGS);
            String profilePic = intent.getStringExtra(PIC_URL);
            boolean verfied = intent.getBooleanExtra(VERIFIED,false);


            if (verfied)
            {
                binding.vefiedImage.setVisibility(View.VISIBLE);
                binding.verifiedText.setVisibility(View.VISIBLE);
            }

            binding.lawyerName.setText(name);
            binding.specialityTxt.setText(speciality);
            binding.rateTxt.setText("£"+rate);

//            binding.ra


            Glide.with(binding.profilePic.getContext())
                    .load(profilePic)
                    .into(binding.profilePic);


        }
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




