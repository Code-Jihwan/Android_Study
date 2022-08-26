package com.example.tablayout;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;

//TabLayout (fragment 전환)

public class MainActivity extends AppCompatActivity {
    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();
    private Fragment3 fragment3 = new Fragment3();
    private Fragment4 fragment4 = new Fragment4();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment1).commit();
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //tab 상태 선택X -> 선택O
                int position = tab.getPosition();

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                }
                else if (position == 1) {
                    selected = fragment2;
                }
                else if (position == 2) {
                    selected = fragment3;
                }
                else {
                    selected = fragment4;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab의 상태가 선택 상태에서 선택되지 않음으로 변경됨.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //이미 선택된 상태의 tab이 사용자에 의해 다시 선택됨.
            }
        });
    }
}