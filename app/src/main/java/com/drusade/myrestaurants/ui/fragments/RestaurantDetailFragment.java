package com.drusade.myrestaurants.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drusade.myrestaurants.R;
import com.drusade.myrestaurants.models.Business;
import com.drusade.myrestaurants.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantDetailFragment extends Fragment implements View.OnClickListener{

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.restaurantImageView) ImageView mImageLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.restaurantNameTextView) TextView mNameLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ratingTextView) TextView mRatingLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.addressTextView) TextView mAddressLabel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.saveRestaurantButton) TextView mSaveRestaurantButton;

    private Business mRestaurant;

    public RestaurantDetailFragment() {
        // Required empty public constructor
    }

    public static RestaurantDetailFragment newInstance(Business restaurant) { //used instead of constructor
        RestaurantDetailFragment restaurantDetailFragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { //Unwrap our restaurant object from the arguments we added in the newInstance() method.
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mRestaurant = Parcels.unwrap(getArguments().getParcelable("restaurant"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { //Ths restaurant object id used to set our imageView and textView
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mRestaurant.getImageUrl()).into(mImageLabel);

        List<String> categories = new ArrayList<>();

        for (Category category: mRestaurant.getCategories()) {
            categories.add(category.getTitle());
        }

        mNameLabel.setText(mRestaurant.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        mRatingLabel.setText(String.format("%s/5", mRestaurant.getRating())); //which is better? 1
        /*mRatingLabel.setText(Double.toString(mRestaurant.getRating()) + "/5");*/ //which is better? or 2
        mPhoneLabel.setText(mRestaurant.getPhone());
        mAddressLabel.setText(mRestaurant.getLocation().toString());

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRestaurant.getUrl()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mRestaurant.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mRestaurant.getCoordinates().getLatitude()
                            + "," + mRestaurant.getCoordinates().getLongitude()
                            + "?q=(" + mRestaurant.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}