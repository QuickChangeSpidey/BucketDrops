package com.akshay.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ActivityMain extends AppCompatActivity{


    @BindView(R.id.btn_add)
    Button mButton;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_drops)
    RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialogAdd();
            }
        });

        setSupportActionBar(mToolbar);
        initBackgroundImage();
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

}
