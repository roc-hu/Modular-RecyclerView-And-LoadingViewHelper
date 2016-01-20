package com.lesehome.carrot.loadingview;

/**
 * 数据源
 * 
 * @param <DATA>
 */
public interface IDataSource<DATA> {
	/**
	 * 获取刷新的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	DATA refresh() throws Exception;

	/**
	 * 获取加载更多的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	DATA loadMore() throws Exception;

	/**
	 * 是否还可以继续加载更多
	 * 
	 * @return
	 */
	boolean hasMore();
}
