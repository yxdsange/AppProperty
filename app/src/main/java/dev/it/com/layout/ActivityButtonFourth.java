package dev.it.com.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityButtonFourth extends AppCompatActivity {
   /**
    *  第一步：xml布局文件中，为Button添加onClick 属性
    第二步：在对应的Activity中，创建一个以onclick 属性值为名字的方法
        a.修饰符为public
        b.返回值为void
        c.传入参数为View类型*/
    private Button btn_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_fourth);
        btn_04 = findViewById(R.id.btn_04);

    }
//  定义 MyButtonClickFourth 对应方法
    public void MyButtonClickFourth(View view) {
        Toast.makeText(ActivityButtonFourth.this,btn_04.getText()+",被点击了",Toast.LENGTH_LONG).show();
    }
}
