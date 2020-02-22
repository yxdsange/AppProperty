package com.it.dev.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import dev.it.com.layout.R;

public class ActivityAlterDialog extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_dialog);
        initDilaog();
    }

    /**
     * 初始化AlterDialog
     */
    public void initDilaog() {
//    Dialog 构造器
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityAlterDialog.this);
//        设置标题
        builder.setTitle("提示");
//        图标
//        builder.setIcon(R.mipmap.ic_launcher); // 自定义设置icon
        builder.setIcon(android.R.drawable.btn_dialog);  // 使用系统图标
//        设置内容
        builder.setMessage("您是否狠心理我而去？");
//  setPositiveButton(表示按钮的文本，表示点击按钮触发单机事件)
//        int which 点击按钮的标识符
        builder.setPositiveButton("OK ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        
        builder.setNegativeButton("Cancle", null);

        builder.setNeutralButton("稍后提醒", null);

        dialog = builder.create(); // 构造Dialog对象

    }

    /**
     * 单机按钮弹出AlterDialog
     *
     * @param view
     */
    public void showDialog(View view) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * 表示点击返回键时调用的方法
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }
//  处理返回键事件
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK){
//            dialog.show();
//        }
//        return super.onKeyDown(keyCode, event);
//
//    }
}
