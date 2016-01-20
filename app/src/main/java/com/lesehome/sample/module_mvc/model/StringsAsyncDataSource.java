package com.lesehome.sample.module_mvc.model;

import android.util.Log;

import com.lesehome.carrot.loadingview.requesthandle.AsyncRequestHandle;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lesehome.carrot.loadingview.IAsyncDataSource;
import com.lesehome.carrot.loadingview.RequestHandle;
import com.lesehome.carrot.loadingview.ResponseSender;

import java.util.ArrayList;
import java.util.List;

public class StringsAsyncDataSource implements IAsyncDataSource<List<String>> {
    private int mPage;
    private int mMaxPage = 5;

    private static AsyncHttpClient client = new AsyncHttpClient();

    public StringsAsyncDataSource() {
        super();
    }

    @Override
    public RequestHandle refresh(ResponseSender<List<String>> sender) throws Exception {
        return loadBooks(sender, 1);
    }

    @Override
    public RequestHandle loadMore(ResponseSender<List<String>> sender) throws Exception {
        return loadBooks(sender, mPage + 1);
    }

    @Override
    public boolean hasMore() {
        Log.d("xxxx", "hasMore mMaxPage:" + mMaxPage + " mPage;" + mPage);
        return mPage < mMaxPage;
    }

    private RequestHandle loadBooks(final ResponseSender<List<String>> sender, final int page) throws Exception {
        String url = "http://www.baidu.com";
        RequestParams params = new RequestParams();
        params.put("api_key", "75ee6c644cad38dc8e53d3598c8e6b6c");
        return new AsyncRequestHandle(client.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                List<String> books = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    books.add("page" + i + "  Java编程思想 ");
                }
                mPage = page;
                sender.sendData(books);
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                List<String> books = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    books.add("page" + page + "  Java编程思想 ");
                }
                mPage = page;
                sender.sendData(books);
            }
        }));
    }
}
