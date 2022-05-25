package com.drusade.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.locationTextView) TextView mLocationTextView;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.listView) ListView mListView;

    private final String[] restaurants = new String[] {"Java", "Mayura",
            "Zen Garden", "Red Ginger", "Talisman", "Haru",
            "CJ's", "KFC", "Pizzaro", "Cultivar",
            "Galitos", "Sanford", "Art Cafe",
            "Big Square", "Subway"};

    private final String[] cuisines = new String[] {"Coffee", "Indian Food",
            "Asian food", "Steak", "Samosas", "Sushi", "Chicken Soup",
            "Fast Food", "Pizza", "Mexican", "Chicken", "Fast Food", "Pasta",
            "Ribs", "Subs"};

    public static final String TAG = RestaurantsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Log.d(TAG, "In the onCreate method!");
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText(String.format("%s%s%s", getString(R.string.restaurants_near_you), " ", location));
    }
}