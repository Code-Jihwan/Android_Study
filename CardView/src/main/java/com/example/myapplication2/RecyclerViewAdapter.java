package com.example.myapplication2;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    String TAG = "RecyclerViewAdapter";

    ArrayList<CardViewItem> cardViewItems;
    Context context;

    public RecyclerViewAdapter(Context context, ArrayList<CardViewItem> cardViewItems){
        this.cardViewItems = cardViewItems;
        this.context = context;
    }

    public RecyclerViewAdapter(ArrayList<CardViewItem> dataModels) {
        this.cardViewItems = dataModels;
    }

    @Override
    public int getItemCount() {
        return cardViewItems.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");
            Log.w(";;;;ppp", "dddd" + cardViewItems.size());
            ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.title.setText(cardViewItems.get(position).getTitle());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById((R.id.image));
            title = (TextView) itemView.findViewById((R.id.title));
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
