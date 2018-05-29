package com.studiographene.lawyerly.basecode.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.studiographene.lawyerly.Dashboard.DashboardActivity;
import com.studiographene.lawyerly.basecode.Application;

import javax.inject.Inject;


/**
 * BaseFragment
 */
public abstract class BaseFragment extends Fragment implements BaseView {

   // protected FragmentEventListener mListener;
    private InputMethodManager mInputManager;
   // private static AlertDialogFragment alertDialogFragment;


    @Inject
    DashboardActivity dashboardActivity;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return createView(inflater, container, savedInstanceState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((Application) getActivity().getApplication()).getNetComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!isNetworkRequired()) {
            return;
        }

    }

    protected boolean isNetworkRequired() {
        return true;
    }


    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (FragmentEventListener) activity;
//        } catch (ClassCastException e) {
//            UIHelper.log("Activity doesn't instance of FragmentEventListener. You must implement FragmentEventListener");
//        }
        mInputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        attach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }




    public boolean isDestroy() {
        return getActivity() == null;
    }

    protected void hideKeyboard() {
        if (mInputManager == null || getActivity().getCurrentFocus() == null) {
            return;
        }
        mInputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    protected void updateActionButtonState() {
    }


    protected void attach(Activity activity) {
    }



    public  void showSnackBar(String s, View view)
    {
        Snackbar.make(view, s, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    public  void showSnackBar(String s)
    {
        if(getView() != null)
        {
            Snackbar.make(getView(), s, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

    }



    public void showProgressBar(Boolean b, View bar) {
        if((bar.getVisibility() == View.GONE || bar.getVisibility() == View.INVISIBLE)&& b == true)
        {
            bar.setVisibility(View.VISIBLE);
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        if(bar.getVisibility() == View.VISIBLE && b == false)
        {
            bar.setVisibility(View.GONE);
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }



    @Override
    public void showProgressBar(Boolean b) {
        Log.d("TAG", "showProgressBar: ");
        if(getLoader() != null) {

            if (b) {
                getLoader().setVisibility(View.VISIBLE);
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }else {
                Log.d("TAG", "showProgressBar: inside false");
                getLoader().setVisibility(View.GONE);
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        }else {
            if (b) {
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }else {

                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }

        }
    }

    @Override
    public void logout() {



    }
    @Override
    public void refresh() {

    }



    @Override
    public void onDestroy() {

        super.onDestroy();
        Runtime.getRuntime().gc();


    }

    public boolean onBackPress() {
        return false;
    }

    public abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
