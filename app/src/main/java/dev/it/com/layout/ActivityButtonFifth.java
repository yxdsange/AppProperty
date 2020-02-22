package dev.it.com.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityButtonFifth extends AppCompatActivity {
//    
    private Button btn01 ,btn02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_fifth);
        btn01=findViewById(R.id.btn01);
        btn02=findViewById(R.id.btn02);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityButtonFifth.this,
                        "点击第一个按钮",Toast.LENGTH_LONG).show();
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityButtonFifth.this,
                        "点击第二个按钮",Toast.LENGTH_LONG).show();
            }
        });
    }
}
