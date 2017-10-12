package com.example.willi.imagecamera;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListFotoActivity extends AppCompatActivity {

    @Bind(R.id.rvListFoto)
    RecyclerView rvList;
    FotoAdapter adapter;
    ArrayList<FotoModel> models = new ArrayList<>();
    DBMasters dbMasters = new DBMasters(ListFotoActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_foto);
        ButterKnife.bind(this);
        setContent();
    }
    private void setContent(){
        rvList.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor = dbMasters.selectAll();
        for (int i=0;i<cursor.getCount();i++){
            if (i==0)cursor.moveToFirst();
            else cursor.moveToNext();
            FotoModel model = new FotoModel();
            model.set_id(cursor.getString(cursor.getColumnIndex("_id")));
            model.setNama(cursor.getString(cursor.getColumnIndex("name")));
            model.setPath(cursor.getString(cursor.getColumnIndex("path")));
            Log.i("namaOrang",model.getNama());
            models.add(model);
        }
        adapter = new FotoAdapter(models);
        rvList.setAdapter(adapter);
    }
}
