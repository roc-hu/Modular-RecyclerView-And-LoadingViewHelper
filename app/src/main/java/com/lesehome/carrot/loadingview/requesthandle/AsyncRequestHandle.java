//package com.lesehome.carrot.loadingview.requesthandle;
//
//import com.lesehome.carrot.loadingview.RequestHandle;
//
//public class AsyncRequestHandle implements RequestHandle {
//	private com.loopj.android.http.RequestHandle handle;
//
//	public AsyncRequestHandle(com.loopj.android.http.RequestHandle handle) {
//		super();
//		this.handle = handle;
//	}
//
//	@Override
//	public void cancle() {
//		handle.cancel(true);
//	}
//
//	@Override
//	public boolean isRunning() {
//		return !handle.isFinished();
//	}
//
//}
