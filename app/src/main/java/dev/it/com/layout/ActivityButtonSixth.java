package dev.it.com.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityButtonSixth extends AppCompatActivity {
    /**
     *通过创建内部类为多个按钮添加监听器
     *
     * 创建内部类实现OnclickListener接口
     * onclick方法中，通过switch（R.id.XX）方式区别当前被点击的按钮是哪个；
     *之后再对相应的按钮做不同的处理
     */
    private Button btn01, btn02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_sixth);

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);


    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn01:

                    Toast.makeText(ActivityButtonSixth.this,
                            "点击第一个按钮",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn02:
                    Toast.makeText(ActivityButtonSixth.this,
                            "点击第一个按钮",Toast.LENGTH_LONG).show();
                    break;

            }
        }
    }
}
