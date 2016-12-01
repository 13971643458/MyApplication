package com.example.liuwenxiang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  void onClick(View view){
        Toast.makeText(MainActivity.this, "链接失败，请稍后登录", Toast.LENGTH_SHORT).show();
    }
}
