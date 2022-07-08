package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewAdapter adapter;
        RecyclerView recyclerView;

        ArrayList<CardViewItem> cardViewItems = new ArrayList();

        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "aaaa"));
        cardViewItems.add(new CardViewItem(0000, "qqqw"));
        cardViewItems.add(new CardViewItem(0000, "wwww"));
        cardViewItems.add(new CardViewItem(0000, "dddd"));
        cardViewItems.add(new CardViewItem(0000, "vvvv"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));
        cardViewItems.add(new CardViewItem(0000, "ssss"));


        Log.e("9999999","pp" + cardViewItems.size());

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecyclerViewAdapter(this, cardViewItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


    }
}

//https://github.com/Swalloow/AndroidStudy/tree/master/MyCardView/app/src/main/java/com/example/mycardview
