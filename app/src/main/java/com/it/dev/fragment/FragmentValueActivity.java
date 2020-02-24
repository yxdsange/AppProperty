package com.it.dev.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dev.it.com.layout.R;

public class FragmentValueActivity extends AppCompatActivity implements IButton{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_value);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new FragmentValues1()).commit();
    }

    @Override
    public void onFragmentBtnClick(String text) {
        FragmentValues4 fragmentValues4=(FragmentValues4)getSupportFragmentManager().findFragmentById(R.id.frg4);
        fragmentValues4.setFragmentTextValue(text);
    }
}
