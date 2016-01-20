package com.lesehome.carrot.loadingview;

/**
 * @param <DATA>
 */
public interface IDataAdapter<DATA> {

	void notifyDataChanged(DATA data, boolean isRefresh);

	DATA getData();

	boolean isEmpty();

}
