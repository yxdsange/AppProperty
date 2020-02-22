package com.it.dev.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import dev.it.com.layout.R;


public class ActivityProgressBar extends AppCompatActivity {
    private ProgressBar progressbar_horizontal;
    private Button btn_add01, btn_add02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        initView();
        progressbar_horizontal.setProgress(30);
        progressbar_horizontal.setSecondaryProgress(50);

        ButtonListener btnButtonListener=new ButtonListener();
        btn_add01.setOnClickListener(btnButtonListener);
        btn_add02.setOnClickListener(btnButtonListener);
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btn_add01:
                    progressbar_horizontal.incrementProgressBy(20);
                    break;
                case R.id.btn_add02:
                    progressbar_horizontal.incrementSecondaryProgressBy(50);
                    break;

            }
        }
    }

    private void initView() {
        progressbar_horizontal = findViewById(R.id.progressbar_horizontal);
        btn_add01 = findViewById(R.id.btn_add01);
        btn_add02 = findViewById(R.id.btn_add02);
    }
}
