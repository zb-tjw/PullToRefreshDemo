package com.sunday.imoocpulltorefresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sunday.imoocpulltorefresh.cate.CateActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onToCateActivity (View v){
        startActivity(new Intent(this, CateActivity.class));
    }

}
