package com.example.fragment_bottomnavigationview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout00, fragment1, null);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.menu1:
                        transaction.replace(R.id.layout00, fragment1).commitAllowingStateLoss();
                        transaction.addToBackStack(null);   //.addToBackStack(null) 추가 시 -> 스택에 쌓이므로 뒤로가기 시 스택에 있는 프래그먼트들이 순서대로 onDestory 된다.
                        break;
                    case R.id.menu2:
                        transaction.replace(R.id.layout00, fragment2).commitAllowingStateLoss();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.menu3:
                        transaction.replace(R.id.layout00, fragment3).commitAllowingStateLoss();
                        transaction.addToBackStack(null);
                        break;
                }
            }
        });
    }
}