package com.drusade.myrestaurants.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.drusade.myrestaurants.R;
import com.drusade.myrestaurants.adapters.RestaurantPagerAdapter;
import com.drusade.myrestaurants.models.Business;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private RestaurantPagerAdapter adapterViewPager;
    List<Business> mRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);

        mRestaurants = Parcels.unwrap(getIntent().getParcelableExtra("restaurants"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new RestaurantPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mRestaurants);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }

}