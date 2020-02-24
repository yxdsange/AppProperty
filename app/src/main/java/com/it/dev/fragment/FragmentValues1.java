package com.it.dev.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import dev.it.com.layout.R;


public class FragmentValues1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1, container, false);
        final EditText editText = view.findViewById(R.id.et);
        Button button = view.findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                通过 setArguments 传递数据形式，系统可以暂存数据，如果通过构造方法传递数据，是不会被系统暂存的；
                FragmentValues2 fragmentValues2 = new FragmentValues2();
                Bundle bundle=new Bundle();
                bundle.putString("arg",editText.getText().toString());
                fragmentValues2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentValues2).commit();
            }
        });
        return view;
    }

}
