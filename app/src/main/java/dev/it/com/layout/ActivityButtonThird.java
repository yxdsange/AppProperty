package dev.it.com.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 直接将当前的Activity实现OnClickLinstener 方法
 */
public class ActivityButtonThird extends AppCompatActivity implements View.OnClickListener {
    private Button btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_third);
        btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(ActivityButtonThird.this, btn03.getText() + "按钮被点击了", Toast.LENGTH_LONG).show();
    }
}

