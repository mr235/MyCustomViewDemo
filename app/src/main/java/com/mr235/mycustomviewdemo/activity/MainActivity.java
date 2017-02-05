package com.mr235.mycustomviewdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mr235.mycustomviewdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_first_custom_view).setOnClickListener(this);
        findViewById(R.id.bt_circle_menu).setOnClickListener(this);
        findViewById(R.id.bt_pie_chart).setOnClickListener(this);
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
            case R.id.bt_pie_chart:
                startActivity(new Intent(this, PieChartActivity.class));
                break;

        }
    }
}
