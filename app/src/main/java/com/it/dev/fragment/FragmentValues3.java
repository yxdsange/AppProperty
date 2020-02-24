package com.it.dev.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import dev.it.com.layout.R;

public class FragmentValues3 extends Fragment implements View.OnClickListener {

    private IButton  mIbutton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment3,container,false);
        Button button1=view.findViewById(R.id.btn_1);
        Button button2=view.findViewById(R.id.btn_2);
        Button button3=view.findViewById(R.id.btn_3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        mIbutton.onFragmentBtnClick(((Button)v).getText().toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mIbutton= (IButton) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
