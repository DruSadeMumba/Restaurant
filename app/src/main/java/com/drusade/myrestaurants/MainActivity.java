package com.drusade.myrestaurants;

import androidx.appcompat.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
        mFindRestaurantsButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Ouchie! \uD83D\uDE31", Toast.LENGTH_LONG).show();
        });
    }
}