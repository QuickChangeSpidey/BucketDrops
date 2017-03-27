package com.akshay.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.akshay.bucketdrops.beans.Drop;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by akshay on 3/25/17.
 */

public class DialogAdd extends DialogFragment {

    @BindView(R.id.et_drop)
    EditText mInputWhat;

    @BindView(R.id.btn_close)
    ImageButton mBtnClose;

    @BindView(R.id.btn_add_it)
    Button mBtnAdd;

    @BindView(R.id.bpv_date)
    DatePicker mInputWhen;

    public DialogAdd() {

    }

    private View.OnClickListener mBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId())
            {
                case R.id.btn_add_it:
                    addAction();
                    break;
            }

            dismiss();
        }
    };

    private void addAction() {

        String what=mInputWhat.getText().toString();
        long now = System.currentTimeMillis();
        Realm realm=Realm.getDefaultInstance();
        Drop drop= new Drop(what, now, 0, false);
        realm.beginTransaction();
        realm.copyToRealm(drop);
        realm.commitTransaction();
        realm.close();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogue_add,container,false);
        ButterKnife.bind(this,view);
        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnClose.setOnClickListener(mBtnClickListener);
        mBtnAdd.setOnClickListener(mBtnClickListener);
    }


}
