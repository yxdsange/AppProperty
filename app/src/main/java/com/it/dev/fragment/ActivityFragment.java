package com.it.dev.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dev.it.com.layout.R;

public class ActivityFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void fragmentDemo(View view) {
        startActivity(new Intent(this, DemoFragmentActivity.class));
    }

    public void fragmentManage(View view) {
        startActivity(new Intent(this, ManageFragmentActivity.class));
    }

    public void fragmentValues(View view) {
        startActivity(new Intent(this,FragmentValueActivity.class));
    }

}
