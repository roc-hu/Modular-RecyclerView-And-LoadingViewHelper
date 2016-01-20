package com.lesehome.carrot.loadingview;

public interface IAsyncDataSource<DATA> {

	RequestHandle refresh(ResponseSender<DATA> sender) throws Exception;

	RequestHandle loadMore(ResponseSender<DATA> sender) throws Exception;

	boolean hasMore();

}
