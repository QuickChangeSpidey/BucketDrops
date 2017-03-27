package com.akshay.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.akshay.bucketdrops.Adapters.AdapterDrops;
import com.akshay.bucketdrops.beans.Drop;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;


public class ActivityMain extends AppCompatActivity{

    @BindView(R.id.btn_add)
    Button mButton;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_drops)
    RecyclerView mRecycler;
    RealmChangeListener mChangeListener;
    AdapterDrops mAdapter;
    Realm mRealm;
    RealmResults<Drop> mResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Drop.class).findAllAsync();
        mAdapter = new AdapterDrops(this,mResults);
        mRecycler.setAdapter(mAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialogAdd();
            }
        });

        setSupportActionBar(mToolbar);
        initBackgroundImage();

        mChangeListener = new RealmChangeListener() {
            @Override
            public void onChange(Object element) {
                mAdapter.update(mResults);
            }
        };

    }

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();
        dialog.show(getSupportFragmentManager(),"Add");
    }

    private void initBackgroundImage() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.background)
                .centerCrop()
                .into(imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mResults.addChangeListener(mChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mResults.removeChangeListener(mChangeListener);
    }
}
