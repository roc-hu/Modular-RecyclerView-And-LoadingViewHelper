package com.lesehome.carrot.loadingview;

/**
 * DataSource 可以实现这个接口，进行加载缓存数据
 * 
 * @param <DATA>
 */
public interface IDataCacheLoader<DATA> {

	/**
	 * 加载缓存<br>
	 * 注意这个方法执行于UI线程，不要做太过耗时的操作<br>
	 * 每次刷新的时候触发该方法，该方法在DataSource refresh之前执行<br>
	 * 
	 * @param isEmpty
	 *            adapter是否有数据，这个值是adapter.isEmpty()决定
	 * @return 加载的数据，返回后会执行adapter.notifyDataChanged(data, true)<br>
	 *         相当于refresh执行后adapter.notifyDataChanged(data, true)
	 */
	DATA loadCache(boolean isEmpty);

}
