package com.it.dev.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import dev.it.com.layout.R;

public class ActivitySeekBar extends AppCompatActivity {
    private SeekBar seekerbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_bar);
        seekerbar = findViewById(R.id.seekerbar);
        seekerbar.setMax(100);  // 设置进度条最大进度值
        seekerbar.setProgress(30); // 

        seekerbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//            将在    拖拽进度条发生变化时被触发
                Log.e("sange","进度条的进度是："+seekBar.getProgress());
//              将在进度发生变化时被触发
//                1、当前绑定的seekbar对象
//                2、当前进度
//                3、当前是否为用户手动触发
//
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//            将在 开始   拖拽进度条时被触发
                Log.e("sange","进度条===开始=的进度是："+seekBar.getProgress());

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//            将在  结束  拖拽进度条时被触发
                Log.e("sange","进度条==结束==的进度是："+seekBar.getProgress());

            }
        });
    }

}
