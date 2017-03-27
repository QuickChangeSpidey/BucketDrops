package com.akshay.bucketdrops.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by akshay on 3/26/17.
 */

public class BucketRecyclerView extends RecyclerView {

    private  AdapterDataObserver mObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        }
    };
    public BucketRecyclerView(Context context) {
        super(context);
    }

    public BucketRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BucketRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);

        if(adapter!=null){

            adapter.registerAdapterDataObserver(mObserver);
        }
        mObserver.onChanged();
    }
}
