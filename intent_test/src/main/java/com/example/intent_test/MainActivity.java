package com.example.intent_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button2_1, button3, button4, button5, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);     //Intent test
                startActivity(intent);
            }
        });


        //Data Send (인텐트에 put 해주는 형식)
        button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);     //(현재화면, 이동 후 화면)
                //MainActivity -> MainActivity2     데이터 전달
                intent.putExtra("ID", "데이터 전달 완료!!");             //문자열 넣기 : putExtra()   //문자열 빼기 : getStringExtra()
                startActivity(intent);
            }
        });


        //WEB 이동
        button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/"));
                startActivity(intent);
            }
        });


        button4 = findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity3_spinner_test.class);    //(현재화면, spinner 화면) 이동
                startActivity(intent);
            }
        });


        button5 = findViewById(R.id.btn5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-5678"));     //ACTION VIEW : 데이터 보여줌
                startActivity(intent);
            }
        });


        button6 = findViewById(R.id.btn6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");   //텍스트 파일 기본값
                intent.putExtra(Intent.EXTRA_EMAIL, "aaaa11@naver.com");   //EXTRA_EMAIL , 이메일 주소
                intent.putExtra(Intent.EXTRA_SUBJECT, "email 제목");  //EXTRA_SUBJECT, 이메일 제목
                intent.putExtra(Intent.EXTRA_TEXT, "email 내용"); //EXTRA_TEXT, 이메일 내용
                startActivity(Intent.createChooser(intent, "AAAA"));
            }
        });
    }
}


/*
AndroidManifest.xml 추가
        <activity android:name=".MainActivity2"/>
        <activity android:name=".MainActivity3_spinner_test"/>
*/