package com.example.willi.imagecamera;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

/**
 * Created by willi on 10/11/2017.
 */

public abstract class BaseRecyclerViewAdapter<E> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<E> items;
    protected Context context;
    protected DecimalFormat kursIndonesia;

    public BaseRecyclerViewAdapter(List<E> items) {
        this.items = items;
        kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("IDR ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public E getItem(int i) {
        int l = items.size();
        if(i >= l){
            i = l-1;
        }
        if(i < 0){
            i = 0;
        }
        return items.get(i);
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);
}
