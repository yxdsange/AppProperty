package com.it.dev.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;

import dev.it.com.layout.R;

public class ActivityRatingBar extends AppCompatActivity {
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
              /**
                1、当前绑定的RatingBar
                2、当前rating评分的进度
                3、是否用户出发*/
                Log.e("sange","当前ratingBar:评分"+rating+"是否来自用户"+fromUser+"每次评分的刻度"+ratingBar.getStepSize());

            }
        });


    }
}
