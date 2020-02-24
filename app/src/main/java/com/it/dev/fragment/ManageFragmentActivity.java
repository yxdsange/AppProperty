package com.it.dev.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dev.it.com.layout.R;

public class ManageFragmentActivity extends AppCompatActivity {


    private FragmentManager mfragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_fragment);
    }

    /**
     * public void addFragment(View view) {
     * FragmentManager fragmentManager=getSupportFragmentManager();
     * FragmentTransaction transaction=fragmentManager.beginTransaction();
     * FragmentTest fragmentTest=new FragmentTest();
     * transaction.add(R.id.fl_fragment,fragmentTest);
     * transaction.commit(); // 提交事务；
     * }
     *
     * @param view
     */
    public void add(View view) {
//        FragmentManager fragmentManager= getSupportFragmentManager();  // option +command +F  提取成员变量
        mfragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mfragmentManager.beginTransaction();
        FragmentTest fragmentTest = new FragmentTest();
//        transaction.add(R.id.fl_fragment,fragmentTest);
        transaction.add(R.id.activity_manage_fragment, fragmentTest, "fragment"); // 增加TAG "fragment" 目的找到前边添加的Fragment
        transaction.commit();
    }

    public void remove(View view) {
        FragmentTransaction transaction = mfragmentManager.beginTransaction();
        transaction.remove(mfragmentManager.findFragmentByTag("fragment"));
        transaction.commit(); // 事务提交
    }

    public void replace(View view) {
        FragmentTransaction transaction = mfragmentManager.beginTransaction();
        AnotherFragmentTest anotherFragmentTest = new AnotherFragmentTest();
        transaction.replace(R.id.activity_manage_fragment, anotherFragmentTest);
        transaction.commit();
    }

    public void hide(View view) {
        FragmentTransaction transaction = mfragmentManager.beginTransaction();
        transaction.hide(mfragmentManager.findFragmentByTag("fragment")); // 隐藏
        transaction.commit();
    }

    public void show(View view) {
        FragmentTransaction transaction = mfragmentManager.beginTransaction();
        transaction.show(mfragmentManager.findFragmentByTag("fragment")); // 隐藏
        transaction.commit();
    }
}
