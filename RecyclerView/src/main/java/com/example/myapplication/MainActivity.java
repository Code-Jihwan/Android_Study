package com.example.myapplication;

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

        ArrayList<DataModel> dataModels = new ArrayList();

        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("zzzz", "wwww", "1111", "oooo"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));
        dataModels.add(new DataModel("aaaa", "ssss", "0000", "qqqq"));

        Log.e("9999999","pp" + dataModels.size());

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecyclerViewAdapter(this, dataModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}