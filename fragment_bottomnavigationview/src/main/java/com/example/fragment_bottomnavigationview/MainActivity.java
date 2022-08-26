package com.example.fragment_bottomnavigationview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();
    private Fragment3 fragment3 = new Fragment3();

    private BottomNavigationView bottomNavigationView;
    private LinearLayout containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        containerView = findViewById(R.id.layout00);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout00, fragment1, null);
        transaction.commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        Log.wtf("MainActivity", "menu1 Click");       //Log 보기
                        fragmentManager.beginTransaction().replace(R.id.layout00, fragment1).commit();
                        transaction.addToBackStack(null);   //.addToBackStack(null) 추가 시 -> 스택에 쌓이므로 뒤로가기 시 스택에 있는 프래그먼트들이 순서대로 onDestory 된다.
                                                            // 뒤로 가기 기능.
                        break;
                    case R.id.menu2:
                        Log.wtf("MainActivity", "menu2 Click");
                        fragmentManager.beginTransaction().replace(R.id.layout00, fragment2).commit();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.menu3:
                        Log.wtf("MainActivity", "menu3 Click");
                        fragmentManager.beginTransaction().replace(R.id.layout00, fragment3).commit();
                        transaction.addToBackStack(null);
                        break;
                }
                return true;
            }
        });
    }
}

