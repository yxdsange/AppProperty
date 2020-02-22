package com.it.dev.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.it.com.layout.R;

public class ActivityAlterDialogList extends AppCompatActivity implements View.OnClickListener {
    private Button btn_color, btn_setting, btn_size;
    private TextView tvInfo;
    private int checkedItemId = 0;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_dialog_list);
        initView();
    }

    /**
     * 初始化空间的方法
     */
    public void initView() {
        btn_color = findViewById(R.id.btn_color);
        btn_color.setOnClickListener(this);
        tvInfo = findViewById(R.id.tvInfo);
        btn_setting = findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(this);
        btn_size = findViewById(R.id.btn_size);
        btn_size.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_color:  // 设置字体颜色
                showCommonListDialog();
                break;
            case R.id.btn_setting:
                showAdapterListDialog();
                break;
            case R.id.btn_size: // 设置字体大小
                showSingleListDialog();
                break;
        }
    }

    //  单选列表对话框
    public void showSingleListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("设置字体daxiao");
        builder.setIcon(android.R.drawable.btn_star);
//        final int[] fontVlaues=getResources().getIntArray(R.array.font_value);
        final String[] fontVlaues=getResources().getStringArray(R.array.font_value);
//        setSingleChoiceItems(数据源 id ,默认被选中的item下标 （-1表示没有被默认选中，），点击item的点击事件)
        builder.setSingleChoiceItems(R.array.font_name, checkedItemId, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                checkedItemId=which;

                tvInfo.setTextSize(Float.parseFloat(fontVlaues[which]));
                dialog.dismiss();
            }
        });
        dialog=builder.create();
        dialog.show();
    }

    /**
     * 展示适配器列表Dialog
     */
    public void showAdapterListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("打开设置");
        builder.setIcon(android.R.drawable.btn_star);
//    setAdapter(加载适配器对象，点击列表项触发事件)
//     获取名称数组
        String[] stringNames = getResources().getStringArray(R.array.setting_images);
//        获取图片数组
        String[] imageNames = getResources().getStringArray(R.array.setting_images);

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < stringNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("setting", stringNames[i]);
//      getIdentifier（） 根据资源的名称和类型获得资源的ID
            int imageId = getResources().getIdentifier(imageNames[i], "drawable", getPackageName());
            map.put("image", imageId);
            data.add(map); // 将数据源添加到集合
        }
//        构建 SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item,
                new String[]{"setting", "image"},
                new int[]{R.id.tv_name, R.id.iv_logo}
        );
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null; // 声明intent
                switch (which) {
                    case 0:
//                        通过隐示意图打开系统设置  （WiFi  等）
                        intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        break;
                    case 1:
//                        蓝牙设置
                        intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                        break;
                    case 2:
                        intent = new Intent(Settings.ACTION_SOUND_SETTINGS);
                        break;
                    case 3:
                        intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                        break;
                }
                startActivity(intent);
            }
        });
        builder.create().show();
    }

    /**
     * 展示普通列表的Dialog的方法
     */
    public void showCommonListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityAlterDialogList.this);
        builder.setTitle("设置字体颜色");
        builder.setIcon(android.R.drawable.btn_star);
//        setItems(表示数据源的资源ID ，点击Item中的选项时触发的监听事件)
        builder.setItems(R.array.colors_name, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        tvInfo.setTextColor(Color.RED);
                        break;
                    case 1:
                        tvInfo.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        tvInfo.setTextColor(Color.BLUE);
                        break;
                }
            }
        });
        builder.create().show();
    }
}
