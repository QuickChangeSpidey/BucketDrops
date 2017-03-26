package com.akshay.bucketdrops.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akshay.bucketdrops.R;

/**
 * Created by akshay on 3/26/17.
 */

public class AdapterDrops extends RecyclerView.Adapter {

    private LayoutInflater mInflater;
    public AdapterDrops(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.row_drop,parent,false);
        return new DropHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class DropHolder extends RecyclerView.ViewHolder{
        public DropHolder(View itemView) {
            super(itemView);
        }
    }
}
