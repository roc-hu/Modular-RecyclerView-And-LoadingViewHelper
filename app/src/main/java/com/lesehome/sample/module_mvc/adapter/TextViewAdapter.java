package com.lesehome.sample.module_mvc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lesehome.carrot.loadingview.IDataAdapter;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.sample.R;

import java.util.ArrayList;
import java.util.List;

public class TextViewAdapter extends RecyclerView.Adapter<HViewHolder> implements IDataAdapter<List<String>> {
    private LayoutInflater inflater;
    private List<String> books = new ArrayList<>();

    public boolean isGrid = false;

    public TextViewAdapter(Context context) {
        super();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HViewHolder(inflater.inflate(R.layout.item_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(HViewHolder holder, int position) {
        ((TextView) holder.itemView).setText(books.get(position));
        ((TextView) holder.itemView).setTextSize(20);
        switch (position) {
            case 0:
            case 2:
                if (isGrid) {
                    ((TextView) holder.itemView).setCompoundDrawablesWithIntrinsicBounds(0,
                            R.drawable.email, 0, 0);
                } else {
                    ((TextView) holder.itemView).setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.email, 0, 0, 0);
                }
                break;
            case 1:
            case 3:
                if (isGrid) {
                    ((TextView) holder.itemView).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,
                            R.drawable.github);
                } else {
                    ((TextView) holder.itemView).setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.github, 0, 0, 0);
                }
                break;
            default:
                if (isGrid) {
                    ((TextView) holder.itemView).setCompoundDrawablesWithIntrinsicBounds(0,
                            R.drawable.eye, 0, 0);
                } else {
                    ((TextView) holder.itemView).setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.eye, 0, 0, 0);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public void notifyDataChanged(List<String> data, boolean isRefresh) {
        if (isRefresh) {
            books.clear();
        }
        books.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public List<String> getData() {
        return books;
    }

    @Override
    public boolean isEmpty() {
        return books.isEmpty();
    }

}
