package com.example.chapter3.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private List<TestData> mDataset = new ArrayList<>();

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvTitle;
        private TextView tvHot;
        private View contentView;


        public MyViewHolder(View v) {
            super(v);
            contentView = v;
            tvTitle = v.findViewById(R.id.title);
            tvHot = v.findViewById(R.id.hot);
        }

        public void onBind(int position, TestData data) {
            tvTitle.setText(data.title);
            tvHot.setText(data.hot);

        }

    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.onBind(position, mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public MyAdapter(List<TestData> myDataset) {
        mDataset.addAll(myDataset);
    }

}