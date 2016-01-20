package com.lesehome.sample.module_mvc.model;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lesehome.carrot.loadingview.IAsyncDataSource;
import com.lesehome.carrot.loadingview.RequestHandle;
import com.lesehome.carrot.loadingview.ResponseSender;
import com.lesehome.carrot.loadingview.requesthandle.VolleyRequestHandle;
import com.lesehome.sample.utils.MyVolley;

public class StringsVolleyDataSource implements IAsyncDataSource<List<String>> {
	private int mPage;
	private int mMaxPage = 5;

	@Override
	public RequestHandle refresh(ResponseSender<List<String>> sender) throws Exception {
		return loadHomeGroup(sender, 1);
	}

	@Override
	public RequestHandle loadMore(ResponseSender<List<String>> sender) throws Exception {
		return loadHomeGroup(sender, mPage + 1);
	}

	@Override
	public boolean hasMore() {
		return mPage < mMaxPage;
	}

	private RequestHandle loadHomeGroup(final ResponseSender<List<String>> sender, final int page) throws Exception {
		String url = "http://www.baidu.com";
		Uri.Builder builder = Uri.parse(url).buildUpon();
		builder.appendQueryParameter("page", String.valueOf(page));
		StringRequest jsonObjRequest = new StringRequest(Request.Method.GET, builder.toString(), new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				List<String> strs = new ArrayList<>();
				for (int i = 0; i < 30; i++) {
					strs.add("Volley " + i + "  Java编程思想 ");
				}
				mPage = page;
				sender.sendData(strs);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				sender.sendError(error);
			}
		});
		MyVolley.getRequestQueue().add(jsonObjRequest);
		return new VolleyRequestHandle(jsonObjRequest);
	}

}
