package com.epicodus.myrestaurant.ui;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface restaurantFont = Typeface.createFromAsset(getAssets(), "fonts/AmaticSC-Regular.ttf");
        mAppNameTextView.setTypeface(restaurantFont);

        mFindRestaurantsButton.setOnClickListener(this);
    }

        @Override
        public void onClick(View v){
            if(v == mFindRestaurantsButton) {
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        }

}
