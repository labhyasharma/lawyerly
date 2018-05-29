package com.studiographene.lawyerly.lawyerdetails;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.studiographene.lawyerly.R;

/**
 * Created by ashu Template.
 */

public class LawyerDetailsActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();


    LawyerDetailsFragment fragment;

//
//    addFragment(fragment, R.id.container, false);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lawyer_details);


        fragment = LawyerDetailsFragment.getInstance(getIntent().getExtras());


        addFragment(fragment, R.id.containerDetails, false);


        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public final void addFragment(LawyerDetailsFragment fragment, int containerId,
                                  boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(containerId, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

}