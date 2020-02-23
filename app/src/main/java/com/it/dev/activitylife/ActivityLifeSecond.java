package com.it.dev.activitylife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import dev.it.com.layout.R;

public class ActivityLifeSecond extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ActivityLifeSecond";
    private Button btn_title, buttonfinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_second);
        Log.d(TAG, "onCreate: ");
        btn_title = findViewById(R.id.btn_title);
        btn_title.setOnClickListener(this);
        if (getIntent() != null) {
//          方案一：getStringExtra 获取传值
//            String buttonTitle=getIntent().getStringExtra(ActivityLife.BUTTON_TITLE);

//            方案二：getBundleExtra 获取传值
            Bundle bundle = getIntent().getBundleExtra(ActivityLife.BUTTON_TITLE);

            if (bundle != null) {
                String buttonTitle = bundle.getString(ActivityLife.BUTTON_TITLE);
                btn_title.setText(buttonTitle);
            }

        }

        buttonfinish = findViewById(R.id.buttonfinish);
        buttonfinish.setOnClickListener(this);

//        final Button button=findViewById(R.id.buttonfinish);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setResult(RESULT_OK);
//                finish();
//            }
//        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(TAG, "onBackPressed: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_title:

                break;
            case R.id.buttonfinish:
                Intent intent=new Intent();
                intent.putExtra("data_back","sange测试");

                setResult(RESULT_OK,intent);

                finish();
                break;
        }
    }
}
