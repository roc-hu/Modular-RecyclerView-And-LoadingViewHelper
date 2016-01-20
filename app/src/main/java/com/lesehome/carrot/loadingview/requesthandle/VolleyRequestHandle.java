package com.lesehome.carrot.loadingview.requesthandle;

import com.android.volley.Request;
import com.lesehome.carrot.loadingview.RequestHandle;

public class VolleyRequestHandle implements RequestHandle {
	private Request<?> request;

	public VolleyRequestHandle(Request<?> request) {
		super();
		this.request = request;
	}

	@Override
	public void cancle() {
		request.cancel();
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}