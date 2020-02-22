package dev.it.com.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityReadioButton extends AppCompatActivity {
    /**
     * 1.RadioButton 是圆形单选框
     * 2.RadioGroup是个可以容多个RadioButton的容器
     * 在RadioGroup中的RadioButton控件可以有多个，但同时有且仅有一个可以被选中
     *
     * @param savedInstanceState
     */

    private RadioGroup rg_sex;
    private RadioButton rb_Male, rb_Female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readio_button);
        rg_sex = findViewById(R.id.rg_sex);
        rb_Male = findViewById(R.id.rb_Male);
        rb_Female = findViewById(R.id.rb_Female);
        rg_sex.setOnCheckedChangeListener(new MyRadioButtonListener());
    }


    class MyRadioButtonListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            选中状态改变是被触发；
            switch (checkedId) {
                case R.id.rb_Male:
                    Toast.makeText(ActivityReadioButton.this,"sex:"+"当前用户选择的："+rb_Male.getText().toString(),Toast.LENGTH_LONG).show();
                    Log.e("yxd","sex:"+"当前用户选择的："+rb_Male.getText().toString());
                    break;
                case R.id.rb_Female:
                    Log.e("yxd","sex:"+"当前用户选择的："+rb_Female.getText().toString());
                    Toast.makeText(ActivityReadioButton.this,"sex:"+"当前用户选择的："+rb_Female.getText().toString(),Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }


}
