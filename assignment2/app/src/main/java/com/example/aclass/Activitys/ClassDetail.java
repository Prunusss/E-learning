package com.example.aclass.Activitys;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.aclass.S_Class.Notify_Fragment;
import com.example.aclass.S_Class.SiliaoTeacher_Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;



public class ClassDetail extends AppCompatActivity  {


    TabLayout tab_layout;
    ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    String[] titles = {"当前课堂", "私信教师"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);

        tab_layout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.ac_tab_vp);
        fragmentList.add(new Notify_Fragment());
        fragmentList.add(new SiliaoTeacher_Fragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(adapter);
        tab_layout.setupWithViewPager(viewPager);
    }



}
class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> mFragments;
    String[] mTitles;
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
