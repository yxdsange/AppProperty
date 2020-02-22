package dev.it.com.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 匿名内部类方法实现 OnClickListener
 * 第一步：获取Button对象
 * 第二步：直接调用Button的setOnClickListener方法
 *  a.在方法中传入new OnClickLinistener(){
 *
 *  }
 */
public class ActivityButtonSecond extends Activity {

    private Button btn_02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butoon_second);
        btn_02=findViewById(R.id.btn_02);
//        匿名内部类方法实现onclicklistener 方法
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityButtonSecond.this,btn_02.getText()+"，按钮被点击了",Toast.LENGTH_LONG).show();
            }
        });
    }
}
