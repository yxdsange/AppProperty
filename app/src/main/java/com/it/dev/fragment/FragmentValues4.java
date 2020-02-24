package com.it.dev.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import dev.it.com.layout.R;

public class FragmentValues4 extends Fragment {

    TextView mTextView ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment4, container, false);
        mTextView=view.findViewById(R.id.tv_value);
        return view;
    }

    public void setFragmentTextValue(String textValue) {
        mTextView.setText(textValue);
    }

}
