package com.drusade.myrestaurants.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.drusade.myrestaurants.models.Business;
import com.drusade.myrestaurants.ui.fragments.RestaurantDetailFragment;

import java.util.List;

public class RestaurantPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mRestaurants;

    public RestaurantPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Business> restaurants) {
        super(fm, behavior);
        mRestaurants = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getName();
    }
}





// FragmentStateAdapter
/*
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }
    */
