package com.studiographene.lawyerly.Dashboard;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.studiographene.lawyerly.R;
import com.studiographene.lawyerly.lawyerslist.LawyersListFragment;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    LawyersListFragment lawyersListFragment = new LawyersListFragment();
    LawyersListFragment lawyersListFragment1 = new LawyersListFragment();
    LawyersListFragment lawyersListFragment2 = new LawyersListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            //noinspection ConstantConditions
            TextView tv=(TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
            //tv.setTypeface(Typeface);
            tabLayout.getTabAt(i).setCustomView(tv);

        }

    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(lawyersListFragment, "FEATURED");
        adapter.addFragment(lawyersListFragment1, "ALL");
        adapter.addFragment(lawyersListFragment2, "FAVS");
        viewPager.setAdapter(adapter);
    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
