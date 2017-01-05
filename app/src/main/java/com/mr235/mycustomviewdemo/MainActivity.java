package com.mr235.mycustomviewdemo;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_first_custom_view).setOnClickListener(this);
        findViewById(R.id.bt_circle_menu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_first_custom_view:
                startActivity(new Intent(this, FirstCustomViewActivity.class));
                break;
            case R.id.bt_circle_menu:
                startActivity(new Intent(this, RemoteControlMenuActivity.class));
                break;

        }
    }
}
