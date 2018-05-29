package com.studiographene.lawyerly.lawyerslist;

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


import com.studiographene.lawyerly.Dashboard.DashboardActivity;
import com.studiographene.lawyerly.basecode.Application;
import com.studiographene.lawyerly.basecode.common.BaseBindingAdapter;
import com.studiographene.lawyerly.basecode.common.BaseFragment;
import com.studiographene.lawyerly.databinding.SingleRecyclerViewLayoutBinding;
import com.studiographene.lawyerly.lawyerdetails.LawyerDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class LawyersListFragment extends BaseFragment implements LawyersListContract.View, BaseBindingAdapter.Listener<Lawyer>, SearchView.OnQueryTextListener {

    private final String TAG = this.getClass().getSimpleName();

    SingleRecyclerViewLayoutBinding binding;
    LawyersListAdapter adapter;
    List<Lawyer> list;

    public static final String NAME = "NAME";
    public static final String RATE = "RATE";
    public static final String RATINGS = "RATINGS";
    public static final String VERIFIED = "VERIFIED";
    public static final String PIC_URL = "PICURL";
    public static final String SPECIALITY = "SPECIALITY";

    @Inject
    DashboardActivity dashboardActivity;

    @Inject
    LawyersListPresenter presenter;

    public static LawyersListFragment getInstance(Bundle bundle) {
        LawyersListFragment fragment = new LawyersListFragment();

        if (bundle == null) {
            bundle = new Bundle();
        }

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = SingleRecyclerViewLayoutBinding.inflate(inflater, container, false);


        adapter = new LawyersListAdapter(getActivity(), new ArrayList<>(), this);
        adapter.setEmptyView(binding.includedEmptyView.emptyView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        binding.recyclerView.setLayoutManager(layoutManager);




        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(adapter);


        presenter.attachView(this);


        binding.swipeRefresh.setOnRefreshListener(() -> {

            binding.swipeRefresh.setRefreshing(false);
        });



        presenter.getLawyerList();

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


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }

    @Override
    public void onItemClick(View view, Lawyer item, int clickType) {


        Intent intent = new Intent(getActivity(), LawyerDetailsActivity.class);
        intent.putExtra(NAME,item.getName());
        intent.putExtra(RATE,item.getRate());
        intent.putExtra(RATINGS,item.getRatings());
        intent.putExtra(PIC_URL,item.getProfilePic());
        intent.putExtra(SPECIALITY,item.getSpeciality());
        intent.putExtra(VERIFIED,item.isVerified());
        startActivity(intent);

    }


    @Override
    public void refreshList(List<Lawyer> lawyers) {
        adapter.swapItems(lawyers);
    }
}




