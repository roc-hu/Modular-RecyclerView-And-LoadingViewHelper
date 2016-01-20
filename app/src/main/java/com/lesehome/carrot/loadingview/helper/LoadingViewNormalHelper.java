package com.lesehome.carrot.loadingview.helper;

import android.view.View;

import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadMoreView;
import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadView;
import com.lesehome.carrot.loadingview.IRefreshView;
import com.lesehome.carrot.loadingview.LoadingViewHelper;

/**
 * 注意 ：<br>
 * <2>contentView 必须有Parent
 * 
 *
 * @param <DATA>
 */
public class LoadingViewNormalHelper<DATA> extends LoadingViewHelper<DATA> {

	public LoadingViewNormalHelper(View contentView) {
		super(new RefreshView(contentView));
	}

	public LoadingViewNormalHelper(View contentView, ILoadView loadView) {
		super(new RefreshView(contentView), loadView);
	}

	public LoadingViewNormalHelper(View contentView, ILoadView loadView, ILoadMoreView loadMoreView) {
		super(new RefreshView(contentView), loadView, loadMoreView);
	}

	private static class RefreshView implements IRefreshView {
		private View contentView;

		public RefreshView(View contentView) {
			super();
			this.contentView = contentView;
		}

		@Override
		public View getContentView() {
			return contentView;
		}

		@Override
		public void setOnRefreshListener(OnRefreshListener onRefreshListener) {

		}

		@Override
		public void showRefreshComplete() {

		}

		@Override
		public void showRefreshing() {

		}

		@Override
		public View getSwitchView() {
			return contentView;
		}

	}

}
