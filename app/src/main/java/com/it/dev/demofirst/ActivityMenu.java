package com.it.dev.demofirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import dev.it.com.layout.R;

/**
 * 1、初始化控件
 * 2、初始化数据
 * 3、为控件添加监听器
 *
 * @param
 */
public class ActivityMenu extends AppCompatActivity {
    private EditText name;
    private RadioGroup rg_menu_sex;
    private CheckBox hot, fish, sour;
    private SeekBar seekBar;
    private Button find;
    private ToggleButton toggleButton;
    //    声明数据
    private List<Food> lists_food;
    //  lists_get 用于放找出的菜品
    private List<Food> lists_get;
    //    在Java代码中生成Person对象
    private Person person;
    //    初始化监听器对象
    private RadioGroupListener radioGroupListener;

    private boolean isFish, isSour, isHot;

    private CheckBoxListener checkBoxListener;

    //    初始化变量，用于存放当前用户选择的预算
    private int price = 30;

    private SeekBarListener seekBarListener;

    private ButtonListener buttonListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
        initData(); // 初始化数据
//        为控件添加监听器
        setListener();
    }

    private void setListener() {
        radioGroupListener = new RadioGroupListener();
//        为当前的控件设置监听器
        rg_menu_sex.setOnCheckedChangeListener(radioGroupListener);


        checkBoxListener = new CheckBoxListener();
        fish.setOnCheckedChangeListener(checkBoxListener);
        sour.setOnCheckedChangeListener(checkBoxListener);
        hot.setOnCheckedChangeListener(checkBoxListener);
        seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        buttonListener = new ButtonListener();
        find.setOnClickListener(buttonListener);
        toggleButton.setOnClickListener(buttonListener);

    }

    //    初始化数据
    private void initData() {
//
        person = new Person();
        lists_food = new ArrayList<Food>();
//        初始化找出的菜单list
        lists_get = new ArrayList<Food>();
//        person = new Person();
//        lists_get = new ArrayList<Food>();
//        lists_food = new ArrayList<Food>();
        lists_food.add(new Food("麻辣香锅", 55, R.mipmap.malahuoguo, true, false, false));

        lists_food.add(new Food("水煮鱼", 48, R.mipmap.shuizhuyu, true, true, false));
        lists_food.add(new Food("麻辣火锅", 80, R.mipmap.malahuoguo, true, true, false));

        lists_food.add(new Food("清蒸鲈鱼", 68, R.mipmap.qingzhengluyu, false, true, false));

        lists_food.add(new Food("桂林米粉", 15, R.mipmap.guilin, false, false, false));
        lists_food.add(new Food("上汤娃娃菜", 28, R.mipmap.wawacai, false, false, false));
        lists_food.add(new Food("红烧肉", 60, R.mipmap.hongshaorou, false, false, false));
        lists_food.add(new Food("木须肉", 40, R.mipmap.muxurou, false, false, false));
        lists_food.add(new Food("酸菜牛肉面", 35, R.mipmap.suncainiuroumian, false, false, true));
        lists_food.add(new Food("西芹炒百合", 38, R.mipmap.xiqin, false, false, false));

        lists_food.add(new Food("酸辣汤", 40, R.mipmap.suanlatang, true, false,
                true));
    }

    private void initView() {
        name=findViewById(R.id.et_name);



        rg_menu_sex = findViewById(R.id.rg_menu_sex);
        hot = findViewById(R.id.db_hot);
        fish = findViewById(R.id.cb_fish);
        sour = findViewById(R.id.cb_sour);
        seekBar = findViewById(R.id.sb_plan);
        seekBar.setProgress(30);
        find = findViewById(R.id.find);
        toggleButton = findViewById(R.id.tb_click);
        find = findViewById(R.id.find);
    }


    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            当用户选择当前radiogroup组中被触发；
            switch (checkedId) {
                case R.id.rbMale:
                    person.setSex("男");
                    break;
                case R.id.rbFemal:
                    person.setSex("女");
                    break;
            }
            Log.e("sange", person.getSex());
        }
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            当控件改变时触发
            CheckBox checkBox = (CheckBox) buttonView;
            switch (checkBox.getId()) {
                case R.id.cb_fish:
                    if (isChecked) {
                        isFish = true;
                    } else {
                        isFish = false;
                    }
                    break;
                case R.id.cb_sour:
                    if (isChecked) {
                        isSour = true;
                    } else {
                        isSour = false;
                    }
                    break;
                case R.id.db_hot:
                    if (isChecked) {
                        isHot = true;
                    } else {
                        isHot = false;
                    }
                    break;
            }
            Log.e("当前的状态", "辣" + isHot + "海鲜" + isFish + "酸" + isSour);
        }
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
            price = progress;
            Toast.makeText(ActivityMenu.this, "价格：" + price, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.find:
//  当用户点击寻找时，需要筛查信息，并吧结果显示在imageView上
                    checkData();
                    break;
                case R.id.tb_click:

                    break;

            }
        }

        private void checkData() {
//            找出菜品

            for (int i = 0; i < lists_food.size(); i++) {
//
                Food food = lists_food.get(i);
                if ((food.getPic() <= price) && (food.isFish() == isFish && food.isHot() == isHot && food.isSour() == isSour)) {
                    lists_get.add(food);

                }
            }
            Log.e("sange", "=======" + lists_get.size());
        }

    }
}




