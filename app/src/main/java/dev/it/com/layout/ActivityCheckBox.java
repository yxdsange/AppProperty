package dev.it.com.layout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityCheckBox extends AppCompatActivity {
    private CheckBox cb_game, cb_travel, cb_read;
    private CheckBoxListener checkBoxListener;
    private Button btn_checkall, btn_canclecheckall, btn_getresult;
    private TextView tv_showresult;
    private List<String> lists;
    //    生成监听器对象
    OnClickListener onClickListener = new OnClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        initView();
        setListener();
        initDate();
    }

    private void initDate() {
//        初始化数据
        lists = new ArrayList<String>();
    }

    //  单独写一个方法，初始化控件；
    private void initView() {
        cb_game = findViewById(R.id.cb_game);
        cb_travel = findViewById(R.id.cb_travel);
        cb_read = findViewById(R.id.cb_read);
        btn_checkall = findViewById(R.id.btn_checkall);
        btn_checkall.setOnClickListener(onClickListener);
        btn_canclecheckall = findViewById(R.id.btn_canclecheckall);
        btn_canclecheckall.setOnClickListener(onClickListener);
        btn_getresult = findViewById(R.id.btn_getresult);
        btn_getresult.setOnClickListener(onClickListener);
        tv_showresult = findViewById(R.id.tv_showresult);
    }

    private void setListener() {
        checkBoxListener = new CheckBoxListener();
        cb_game.setOnCheckedChangeListener(checkBoxListener);
        cb_travel.setOnCheckedChangeListener(checkBoxListener);
        cb_read.setOnCheckedChangeListener(checkBoxListener);
    }

    //    onClicklistener 监听
    class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_checkall:
                    cb_game.setChecked(true);
                    cb_travel.setChecked(true);
                    cb_read.setChecked(true);
                    Toast.makeText(ActivityCheckBox.this, "当前点了" + btn_checkall.getText(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_canclecheckall:
                    Toast.makeText(ActivityCheckBox.this, "当前点了" + btn_canclecheckall.getText(), Toast.LENGTH_LONG).show();
                    cb_game.setChecked(false);
                    cb_travel.setChecked(false);
                    cb_read.setChecked(false);
                    break;
                case R.id.btn_getresult:
                    Toast.makeText(ActivityCheckBox.this, "当前点了" + btn_getresult.getText(), Toast.LENGTH_LONG).show();
                    if (cb_game.isChecked()) {
                        lists.add(cb_game.getText().toString());
                    }
                    if (cb_travel.isChecked()) {
                        lists.add(cb_game.getText().toString());
                    }
                    if (cb_read.isChecked()) {
                        lists.add(cb_game.getText().toString());
                    }

                    tv_showresult.setText(lists.toString());
                    lists.clear();

                    break;
            }
        }
    }

    //  checkBox 匿名内部类实现监听方法
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        当选中状态发生变化是出发；
            CheckBox checkBox = (CheckBox) buttonView; // 向下转型；
            switch (checkBox.getId()) {
                case R.id.cb_game:
                    if (isChecked) {
                        Toast.makeText(ActivityCheckBox.this, "少玩游戏，多写代码！", Toast.LENGTH_LONG).show();
                        cb_game.setTextColor(Color.RED);
                    }else {
                        cb_game.setTextColor(Color.BLACK);
                    }
                    Toast.makeText(ActivityCheckBox.this, "当前点了电竞" + isChecked, Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb_read:
                    Toast.makeText(ActivityCheckBox.this, "当前点了电竞" + isChecked, Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb_travel:
                    Toast.makeText(ActivityCheckBox.this, "当前点了电竞" + isChecked, Toast.LENGTH_LONG).show();
                    break;
            }


        }
    }

}
