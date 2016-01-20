package com.lesehome.carrot.recycler.modularadapter.impl;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;

/**
 * RecyclerView.ViewHolderHelper
 *
 * Created by hcp on 16/1/7.
 */
public class HViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener, View.OnLongClickListener {

    private Object tag;

    private SparseArray<View> views;

    private IAdapterItem.OnItemClickListener mOnItemClickListener;
    private IAdapterItem.OnItemLongClickListener mOnItemLongClickListener;

    public HViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        this.views = new SparseArray<>();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            v.setTag(getTag());
            mOnItemClickListener.onItemClick(v, getAdapterPosition(), getItemViewType());
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemLongClickListener != null) {
            v.setTag(getTag());
            return mOnItemLongClickListener.onItemLongClick(v, getAdapterPosition(), getItemViewType());
        }
        return false;
    }

    public android.widget.ImageView getIv(int viewId) {
        return findView(viewId);
    }

    public android.widget.TextView getTv(int viewId) {
        return findView(viewId);
    }

    public android.widget.EditText getEdt(int viewId) {
        return findView(viewId);
    }

    public android.widget.CheckBox getChk(int viewId) {
        return findView(viewId);
    }

    public android.widget.RadioButton getRdoBtn(int viewId) {
        return findView(viewId);
    }

    public android.widget.Button getBtn(int viewId) {
        return findView(viewId);
    }

    /**
     * 取得 ViewGroup组件
     *
     * @param viewId
     * @return
     */
    public android.view.ViewGroup getVg(int viewId) {
        return findView(viewId);
    }

    public <T extends View> T findView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public IAdapterItem.OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(IAdapterItem.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public IAdapterItem.OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    public void setOnItemLongClickListener(IAdapterItem.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }
}
