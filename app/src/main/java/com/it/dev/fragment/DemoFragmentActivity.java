package com.it.dev.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dev.it.com.layout.R;

public class DemoFragmentActivity extends AppCompatActivity {

    private FragmentManager mfragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fragment);
    }

    public void addFragment(View view) {
        mfragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= mfragmentManager.beginTransaction();
        FragmentTest fragmentTest=new FragmentTest();
        transaction.add(R.id.fl_fragment,fragmentTest);
        transaction.commit(); // 提交事务；
    }
}
