package com.example.myapplication;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    String TAG = "RecyclerViewAdapter";

    ArrayList<DataModel> dataModels;
    Context context;

    public RecyclerViewAdapter(Context context, ArrayList<DataModel> dataModels){
        this.dataModels = dataModels;
        this.context = context;
    }

    public RecyclerViewAdapter(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");
            Log.w(";;;;ppp", "dddd" + dataModels.size());
            ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.title.setText(dataModels.get(position).getTitle());
        viewHolder.contents.setText(dataModels.get(position).getContents());
        viewHolder.time.setText(dataModels.get(position).getTime());
        viewHolder.writer.setText(dataModels.get(position).getWriter());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView contents;
        private TextView time;
        private TextView writer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txt1);
            contents = itemView.findViewById(R.id.txt2);
            time = itemView.findViewById(R.id.txt3);
            writer = itemView.findViewById(R.id.txt4);
        }
    }
}
