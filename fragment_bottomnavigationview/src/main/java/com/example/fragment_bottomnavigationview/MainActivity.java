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
                        break;
                    case R.id.menu2:
                        transaction.replace(R.id.layout00, fragment2).commitAllowingStateLoss();
                        break;
                    case R.id.menu3:
                        transaction.replace(R.id.layout00, fragment3).commitAllowingStateLoss();
                }
            }
        });
    }
}