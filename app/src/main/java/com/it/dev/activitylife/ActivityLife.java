package com.it.dev.activitylife;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import dev.it.com.layout.R;

public class ActivityLife extends AppCompatActivity implements View.OnClickListener {
    public static final String BUTTON_TITLE = "button_title";  //
    //    创建TAG
    private Button btn_activity, btn_dilalogactivity, btn_dilog;
    private static final String TAG = "ActivityLife";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        initView();
//        String value = savedInstanceState.getString("key");
        Log.i(TAG, "onCreate: ");
    }

    private void initView() {
        btn_activity = findViewById(R.id.btn_activity);
        btn_activity.setOnClickListener(this);

        btn_dilalogactivity = findViewById(R.id.btn_dilalogactivity);
        btn_dilalogactivity.setOnClickListener(this);

        btn_dilog = findViewById(R.id.btn_dilog);
        btn_dilog.setOnClickListener(this);

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
            case R.id.btn_activity:
                Intent intent_activity = new Intent(ActivityLife.this, ActivityLifeSecond.class);
//                方案一：直接putExtra 单一传值
//                intent_activity.putExtra(BUTTON_TITLE, getString(R.string.dialog_title)); //
//                方案二：bundle 多个值传值 类似HashMap
                Bundle bundle = new Bundle();
                bundle.putString(BUTTON_TITLE, getString(R.string.dialog_title));
                intent_activity.putExtra(BUTTON_TITLE, bundle);
//              方案三：序列化传值 a) Serializable  消耗内存高  b)Parcela
                intent_activity.putExtra("", new User()); // 序列化传值
//                startActivity(intent_activity);
                /**
                 * 第一步：startActivityForResult
                 * 第二步：在第二个Activity页面添加setResult(RESULT_OK)
                 * 第三步：在onActivityResult接收activity返回值
                 */
                startActivityForResult(intent_activity, 999);  // 有回掉方式启动Activity
                break;
            case R.id.btn_dilalogactivity:
                break;
            case R.id.btn_dilog:
                initAlterDialog();
                break;
        }
    }


    public void initAlterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLife.this);
        builder.setTitle("AlterDialog Title");
        builder.setMessage("Message");
        builder.setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        builder.show();
    }

    //   Activvity 启动回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) { //
            if (null != data) {
                data.getStringExtra("data_back");
            }
            Log.e("sange", "=====back返回传值");
//            setTitle("前一个页面回来了");
            setTitle( data.getStringExtra("data_back"));
        }
    }
}
