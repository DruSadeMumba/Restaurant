package com.drusade.myrestaurants.ui;

import androidx.appcompat.app.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

import com.drusade.myrestaurants.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("NonConstantResourceId")//still not sure about this
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindRestaurantsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}


/*mFindRestaurantsButton.OnClick(v -> {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
            Toast.makeText(MainActivity.this, location, Toast.LENGTH_LONG).show();*/