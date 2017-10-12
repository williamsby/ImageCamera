package com.example.willi.imagecamera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by willi on 10/11/2017.
 */

public class FotoAdapter extends BaseRecyclerViewAdapter {
    DBMasters dbMasters;
    public FotoAdapter(ArrayList<FotoModel> items) {
        super(items);
    }

    public interface myInterface{
        void onChangeData(Integer changed);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto, parent, false);
        context = parent.getContext();
        dbMasters = new DBMasters(context);
        return new TamuHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final TamuHolder th = (TamuHolder) holder;
        final FotoModel model= (FotoModel) items.get(position);
        File imgFile = new File(model.getPath());
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        th.tvNama.setText(model.getNama());
        th.ivImage.setImageBitmap(myBitmap);
    }

    public static class TamuHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tvNama)
        TextView tvNama;
        @Bind(R.id.ivImage)
        ImageView ivImage;
        public TamuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
