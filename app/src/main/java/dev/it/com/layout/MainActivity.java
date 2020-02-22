package dev.it.com.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.it.dev.bar.ActivityProgressBar;
import com.it.dev.bar.ActivityRatingBar;
import com.it.dev.bar.ActivitySeekBar;
import com.it.dev.demofirst.ActivityMenu;
import com.it.dev.dialog.ActivityDialog;
import com.it.dev.menudemo.ActivityMenuProperty;
import com.it.dev.picker.ActivityPicker;
import com.it.dev.togglebutton.ActivityToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10, btn11, btn12, btn13, btn14, btn15,btn16,btn17,btn18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
//        内部类实现按钮添加监听器方法
        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(this);
        btn02 = findViewById(R.id.btn02);
        btn02.setOnClickListener(this);
        btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(this);
        btn04 = findViewById(R.id.btn04);
        btn04.setOnClickListener(this);
        btn05 = findViewById(R.id.btn05);
        btn05.setOnClickListener(this);
        btn06 = findViewById(R.id.btn06);
        btn06.setOnClickListener(this);
        btn07 = findViewById(R.id.btn07);
        btn07.setOnClickListener(this);
        btn08 = findViewById(R.id.btn08);
        btn08.setOnClickListener(this);
        btn09 = findViewById(R.id.btn09);
        btn09.setOnClickListener(this);
        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(this);
        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(this);
        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(this);
        btn13 = findViewById(R.id.btn13);
        btn13.setOnClickListener(this);
        btn14 = findViewById(R.id.btn14);
        btn14.setOnClickListener(this);

        btn15 = findViewById(R.id.btn15);
        btn15.setOnClickListener(this);
        btn16 = findViewById(R.id.btn16);
        btn16.setOnClickListener(this);
        btn17=findViewById(R.id.btn17);
        btn17.setOnClickListener(this);

        btn18=findViewById(R.id.btn18);
        btn18.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn01:
                Toast.makeText(MainActivity.this, btn01.getText() + "按钮被点击了；", Toast.LENGTH_LONG).show();
                Intent intent_01 = new Intent(MainActivity.this, ActivityButtonFirst.class);
                startActivity(intent_01);
                break;
            case R.id.btn02:
                Intent intent_02 = new Intent(MainActivity.this, ActivityButtonSecond.class);
                startActivity(intent_02);
                break;
            case R.id.btn03:
                Intent intent_03 = new Intent(MainActivity.this, ActivityButtonThird.class);
                startActivity(intent_03);
                break;
            case R.id.btn04:
                Intent intent_04 = new Intent(MainActivity.this, ActivityButtonFourth.class);
                startActivity(intent_04);
                break;
            case R.id.btn05:
                Intent intent_05 = new Intent(MainActivity.this, ActivityButtonFifth.class);
                startActivity(intent_05);
                break;

            case R.id.btn06:
                Intent intent_06 = new Intent(MainActivity.this, ActivityButtonSixth.class);
                startActivity(intent_06);
                break;
            case R.id.btn07:
                Intent intent_07 = new Intent(MainActivity.this, ActivityEdiText.class);
                startActivity(intent_07);
                break;
            case R.id.btn08:
                Intent intent_08 = new Intent(MainActivity.this, ActivityImageView.class);
                startActivity(intent_08);
                break;
            case R.id.btn09:
                Intent intent_09 = new Intent(MainActivity.this, ActivityCheckBox.class);
                startActivity(intent_09);
                break;

            case R.id.btn10:
                Intent intent_10 = new Intent(MainActivity.this, ActivityReadioButton.class);
                startActivity(intent_10);
                break;

            case R.id.btn11:
                Intent intent_11 = new Intent(MainActivity.this, ActivityToggleButton.class);
                startActivity(intent_11);
                break;
            case R.id.btn12:
                Intent intent_12 = new Intent(MainActivity.this, ActivitySeekBar.class);
                startActivity(intent_12);
                break;

            case R.id.btn13:
                Intent intent_13 = new Intent(MainActivity.this, ActivityProgressBar.class);
                startActivity(intent_13);
                break;
            case R.id.btn14:
                Intent intent_14 = new Intent(MainActivity.this, ActivityRatingBar.class);
                startActivity(intent_14);
                break;
            case R.id.btn15:
                Intent intent_15 = new Intent(MainActivity.this, ActivityPicker.class);
                startActivity(intent_15);
                break;

            case R.id.btn16:
                Intent intent_16 = new Intent(MainActivity.this, ActivityMenu.class);
                startActivity(intent_16);
                break;

            case R.id.btn17:
                Intent intent_17 = new Intent(MainActivity.this, ActivityMenuProperty.class);
                startActivity(intent_17);
                break;

            case R.id.btn18:
                Intent intent_18 = new Intent(MainActivity.this, ActivityDialog.class);
                startActivity(intent_18);
                break;
        }
    }

}
