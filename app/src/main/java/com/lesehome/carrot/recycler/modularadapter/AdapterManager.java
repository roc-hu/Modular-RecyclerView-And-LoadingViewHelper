package com.lesehome.carrot.recycler.modularadapter;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;


public class AdapterManager<DATAS> {

    /**
     * Map for ViewType to AdapterDeleage
     */
    SparseArrayCompat<IAdapterItem<DATAS>> adapterItems = new SparseArrayCompat();

    public AdapterManager<DATAS> add(@NonNull IAdapterItem<DATAS> adapterItem) {
        if (adapterItem == null) {
            throw new NullPointerException("IAdapterItem is null!");
        }

        int viewType = adapterItem.getItemViewType();

        if (adapterItems.get(viewType) != null) {
            throw new IllegalArgumentException(
                    "An IAdapterItem is already registered for the viewType = " + viewType
                            + ". Already registered IAdapterItem is " + adapterItems.get(viewType));
        }

        adapterItems.put(viewType, adapterItem);


        return this;
    }


    public AdapterManager<DATAS> remove(@NonNull IAdapterItem<DATAS> adapterItem) {

        if (adapterItem == null) {
            throw new NullPointerException("IAdapterItem is null");
        }

        IAdapterItem<DATAS> queried = adapterItems.get(adapterItem.getItemViewType());
        if (queried != null && queried == adapterItem) {
            adapterItems.remove(adapterItem.getItemViewType());
        }
        return this;
    }


    public AdapterManager<DATAS> remove(int viewType) {
        adapterItems.remove(viewType);
        return this;
    }


    public int getItemViewType(@NonNull DATAS items, int position) {

        if (items == null) {
            throw new NullPointerException("Items datasource is null!");
        }

        int adapterItemCount = adapterItems.size();
        for (int i = 0; i < adapterItemCount; i++) {
            IAdapterItem<DATAS> delegate = adapterItems.valueAt(i);
            if (delegate.isForViewType(items, position)) {
                return delegate.getItemViewType();
            }
        }
        throw new IllegalArgumentException("No IAdapterItem added that matches position=" + position + " in data source");
    }


    @NonNull
    public HViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {

        IAdapterItem<DATAS> adapterItem = this.adapterItems.get(viewType);
        if (adapterItem == null) {
            throw new NullPointerException("No IAdapterItem added for ViewType " + viewType);
        }

        HViewHolder vh = adapterItem.onCreateViewHolder(parent);

        if (vh == null) {
            throw new NullPointerException(
                    "HViewHolder returned from IAdapterItem " + adapterItem + " for ViewType =" + viewType
                            + " is null!");
        }
        return vh;
    }


    public void onBindViewHolder(@NonNull DATAS items, int position,
                                 @NonNull HViewHolder viewHolder) {

        IAdapterItem<DATAS> adapterItem = this.adapterItems.get(viewHolder.getItemViewType());

        if (adapterItem == null) {
            throw new NullPointerException(
                    "No IAdapterItem added for ViewType " + viewHolder.getItemViewType());
        }
        adapterItem.onBindViewHolder(items, position, viewHolder);
    }

}
