package com.it.dev.picker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import dev.it.com.layout.R;

public class ActivityPicker extends AppCompatActivity {

    private TimePicker timePicker;
    private DatePicker datePicker;
    private TextView tv_showresult;
    private int Year, Month, Day, Hour, Minute;
    private String time_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        initView();
        getPicker();
        setPicker();
    }

    private void getPicker() {
//        获取系统当前时间
        Calendar calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        Hour = calendar.get(Calendar.HOUR);
        Minute = calendar.get(Calendar.MINUTE);
    }

    private void setPicker() {
//        设置时间24小时制
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Hour);
        timePicker.setMinute(Minute);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                当时间选择器发生改变时触发；
                Log.e("sange", "From TimePicker " + hourOfDay + ":" + minute);
            }
        });
        datePicker.init(Year, Month, Day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                当日期选择器发生变化是触发
                Log.e("sange", "From Date Picker " + year + "/" + monthOfYear + 1 + "/" + dayOfMonth);
            }
        });
    }


    private void initView() {
        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        tv_showresult = findViewById(R.id.tv_showresult);
        tv_showresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
