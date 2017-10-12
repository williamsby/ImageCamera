package com.example.willi.imagecamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectActionActivity extends AppCompatActivity {

    @Bind(R.id.btnYes)
    Button btnYes;
    @Bind(R.id.btnNo) Button btnNo;
    SelectActionActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        ButterKnife.bind(this);
        activity = this;
        btnYes.setOnClickListener(option);
        btnNo.setOnClickListener(option);
    }

    View.OnClickListener option = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=null;
            switch (v.getId()){
                case R.id.btnYes:
                    i = new Intent(activity,ListFotoActivity.class);
                    break;
                case R.id.btnNo:
                    i = new Intent(activity,MainActivity.class);
                    break;
            }
            activity.startActivity(i);
            activity.finish();
        }
    } ;
}
