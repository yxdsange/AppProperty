package com.it.dev.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.it.dev.demofirst.ActivityMenu;

import dev.it.com.layout.R;

public class ActivityMenuProperty extends AppCompatActivity implements View.OnClickListener {

    private Button option_menu,content_menu,popup_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_property);
        option_menu= findViewById(R.id.option_menu);
        option_menu.setOnClickListener(this);
        content_menu=findViewById(R.id.content_menu);
        content_menu.setOnClickListener(this);
        popup_menu=findViewById(R.id.popup_menu);
        popup_menu.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.option_menu:
                Intent intent_option=new Intent(ActivityMenuProperty.this,ActivityOptionsMenu.class);
                startActivity(intent_option);
                break;
            case R.id.content_menu:
                break;
            case R.id.popup_menu:
                break;
        }
    }
}
