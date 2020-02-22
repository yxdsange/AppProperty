package com.it.dev.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import dev.it.com.layout.R;

public class ActivityToggleButton extends AppCompatActivity {
    private ToggleButton toggleButton;
    private ImageView iv_face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        toggleButton=findViewById(R.id.tb);
        iv_face=findViewById(R.id.iv_face);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()){
                    Toast.makeText(ActivityToggleButton.this,toggleButton.getText().toString(),Toast.LENGTH_LONG).show();
                    iv_face.setImageResource(R.mipmap.happy);
                }else {
                    Toast.makeText(ActivityToggleButton.this,toggleButton.getText().toString(),Toast.LENGTH_LONG).show();
                    iv_face.setImageResource(R.mipmap.nohappy);
                }
            }
        });
    }
}
