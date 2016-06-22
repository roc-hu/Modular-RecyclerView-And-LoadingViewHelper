package com.lesehome.carrot.loadingview;

/**
 * 异步数据源（比如Volley，OkHttp等异步请求使用）
 * Created by hcp on 16/6/22.
 */
public interface IAsyncDataSource<DATA> {

    /**
     * 获取刷新的数据
     *
     * @param sender
     * @throws Exception
     */
    RequestHandle refresh(ResponseSender<DATA> sender) throws Exception;

    /**
     * 获取加载更多的数据
     *
     * @param sender
     * @throws Exception
     */
    RequestHandle loadMore(ResponseSender<DATA> sender) throws Exception;

    /**
     * 是否还可以继续加载更多
     *
     * @return
     */
    boolean hasMore();

}
