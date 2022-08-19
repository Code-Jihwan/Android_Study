package com.example.intent_test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Data Receive
        Intent intent = getIntent();
        result = intent.getStringExtra("ID");           //전달 할 data 받음     //문자열 넣기 : putExtra()   //문자열 빼기 : getStringExtra()
        textView = findViewById(R.id.txtview2);
        textView.setText(result);
        setResult(RESULT_OK, intent);   //응답 전달 후
    }
}


/*
AndroidManifest.xml 추가
        <activity android:name=".MainActivity2"/>
        <activity android:name=".MainActivity3_spinner_test"/>
*/