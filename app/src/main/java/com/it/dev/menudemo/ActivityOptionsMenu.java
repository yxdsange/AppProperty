package com.it.dev.menudemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import dev.it.com.layout.R;

public class ActivityOptionsMenu extends Activity {

    private TextView tv_show;
    private float fontSize = 20.0f;
    private static final int ITEMID = 4; // 菜单项ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        tv_show = findViewById(R.id.tv_show);
        tv_show.setTextSize(fontSize);  // 设置TextView字体大小

    }

    /**
     * 表示当Activity创建选项菜单时回调的方法
     *
     * @param menu
     * @return true 用来显示菜单下昂
     * false 无法显示菜单项
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//
//  获得菜单填充器对象
//        MenuInflater inflater=getMenuInflater();
//  将菜单选项进行填充
//        inflater.inflate(R.menu.optionsmenu,menu);

//        方案一：创建菜单的第一种方式， XML文件
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
//        方案二：创建菜单的第一种方式   通过代码的形式
//      add(groupId 菜单项分组) ,ItemId 菜单项唯一标识id ,order 表示菜单项排序  ，菜单项像是的文本
        menu.add(Menu.NONE, ITEMID, Menu.NONE, "设置style");

//        处理菜单项点击事件的第三种方式
        MenuItem item = menu.findItem(R.id.action_style);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Toast.makeText(ActivityOptionsMenu.this, item.getTitle().toString(), Toast.LENGTH_LONG).show();

                return false;
            }
        });

        return true;
    }

//    菜单点击相应


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId(); // 获取当前点击菜单项的资源ID
        switch (itemId) {
            case R.id.font_group: // 点击设置字体大小
                fontSize += 5;
                tv_show.setTextSize(fontSize);
                break;
            case R.id.action_color: // 点击设置字体颜色
//                随机生成红色
                int red = (int) (Math.random() * 256);
                int green = (int) (Math.random() * 256);
                int blue = (int) (Math.random() * 256);
                tv_show.setTextColor(Color.rgb(red, green, blue));
                break;
            case R.id.action_add:
                fontSize += 5;
                tv_show.setTextSize(fontSize);
                break;

            case R.id.action_sub:
                fontSize -= 5;
                tv_show.setTextSize(fontSize);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    // 表示菜单项被点击时调用的方法
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == ITEMID) {
            tv_show.setText("调用了菜单项第二种点击事件");

        }
        return super.onMenuItemSelected(featureId, item);
    }
}
