package com.example.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private FragmentStateAdapter viewpagerAdapter;
    private CircleIndicator3 circleIndicator;
    private int num_page = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager);

        viewpagerAdapter = new MyAdapter(this, num_page);
        viewPager2.setAdapter(viewpagerAdapter);

        circleIndicator = findViewById(R.id.Indicator);
        circleIndicator.setViewPager(viewPager2);
        circleIndicator.createIndicators(num_page, 0);

        viewPager2.setCurrentItem(1000);    //이미지 시작 지점
        viewPager2.setOffscreenPageLimit(2);    //최대 이미지 수,  현재 페이지를 기준으로 좌, 우의 프래그먼트 생명주기 관리

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewPager2.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                circleIndicator.animatePageSelected(position%num_page);
            }
        });
    }


    //ViewPager 어댑터.(MyAdapter)
    public static class MyAdapter extends FragmentStateAdapter {
        public int mCount;
        public MyAdapter(@NonNull FragmentActivity fragmentActivity, int num_page) {
            super(fragmentActivity);
            mCount = num_page;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            int index = getRealPosition(position);

            if(index==0)
                return new Fragment_01();
            else if (index == 1)
                return new Fragment_02();
            else
                return new Fragment_03();
        }

        @Override
        public int getItemCount() {
            return 2000;
        }
        public int getRealPosition(int position) { return position %mCount; }


        //pagerview_item1_layout.xml 연결
        public static class Fragment_01 extends Fragment {
            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                return (ViewGroup) inflater.inflate(R.layout.pagerview_item1_layout, container);
            }
        }

        //pagerview_item2_layout.xml 연결
        public static class Fragment_02  extends Fragment {
            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                return (ViewGroup) inflater.inflate(R.layout.pagerview_item2_layout, container);
            }
        }

        ////pagerview_item3_layout.xml 연결
        public static class Fragment_03 extends Fragment {
            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                return (ViewGroup) inflater.inflate(R.layout.pagerview_item3_layout, container);
            }
        }
    }
}