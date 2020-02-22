package com.it.dev.dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.it.com.layout.R;

public class ActivityDialog extends AppCompatActivity implements View.OnClickListener {
    private Button activityalterdialog,activityalterdialoglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        activityalterdialog = findViewById(R.id.activityalterdialog);
        activityalterdialog.setOnClickListener(this);
        activityalterdialoglist=findViewById(R.id.activityalterdialoglist);
        activityalterdialoglist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activityalterdialog:
                Intent intentalterdialog = new Intent(ActivityDialog.this, ActivityAlterDialog.class);
                startActivity(intentalterdialog);
                break;
            case R.id.activityalterdialoglist:
                Intent intentalterdialoglist = new Intent(ActivityDialog.this, ActivityAlterDialogList.class);
                startActivity(intentalterdialoglist);
                break;
        }
    }
}
