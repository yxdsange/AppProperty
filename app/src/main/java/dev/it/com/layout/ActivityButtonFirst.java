package dev.it.com.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ActivityButtonFirst extends AppCompatActivity {
    private Button btn01;
    //

    /**
     * 为按钮添加监听器
     * 第一步：XML布局文件中添加<button></button> 空间并为其设置ID
     * 第二部：Java代码中（需要显示XML的activity中），
     * 通过setContentView，装在Button所在的XML布局
     * 第三步：通过ID在activity中获取到Button的对象
     * 第四步：为Button按钮添加监听事件
     * a:创建内部类，并实现onClickListener接口
     * b：重写onClick 方法（当按钮被点击后想干什么）
     * c:生产内部类对象
     * d:为Button设置监听器
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        第二步
        setContentView(R.layout.activity_button_first);
//        第三步
        btn01 = findViewById(R.id.btn_01);
        MyButtonFirstListener myButtonFirstListener=new MyButtonFirstListener();
        btn01.setOnClickListener(myButtonFirstListener);
    }

    //    第四步：
//    创建内部类，并实现onc
    class MyButtonFirstListener implements View.OnClickListener

    {
        @Override
        public void onClick(View v) {
//        该方法将在被点击时调用；V对象为绑定的控件；
            Toast.makeText(ActivityButtonFirst.this, btn01.getText() + "被点击了", Toast.LENGTH_LONG).show();
        }
    }
}
