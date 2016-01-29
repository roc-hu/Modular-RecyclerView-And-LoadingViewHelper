package com.lesehome.carrot.loadingview.helper;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadMoreView;
import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadView;
import com.lesehome.carrot.loadingview.IRefreshView;
import com.lesehome.carrot.loadingview.LoadingViewHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注意 ：<br>
 * <2>SwipeRefreshLayout必须有Parent
 * 
 * @param <DATA>
 */
public class LoadIngViewSwipeRefreshHelper<DATA> extends LoadingViewHelper<DATA> {
	public LoadIngViewSwipeRefreshHelper(SwipeRefreshLayout swipeRefreshLayout) {
		super(new RefreshView(swipeRefreshLayout));
	}
	public LoadIngViewSwipeRefreshHelper(SwipeRefreshLayout swipeRefreshLayout, ILoadView loadView, ILoadMoreView loadMoreView) {
		super(new RefreshView(swipeRefreshLayout), loadView, loadMoreView);
	}

	private static class RefreshView implements IRefreshView {
		private SwipeRefreshLayout swipeRefreshLayout;
		private View mTarget;

		public RefreshView(SwipeRefreshLayout swipeRefreshLayout) {
			this.swipeRefreshLayout = swipeRefreshLayout;
			if (swipeRefreshLayout.getParent() == null) {
				throw new RuntimeException("SwipeRefreshLayout 必须有Parent");
			}
			try {
				Method method = swipeRefreshLayout.getClass().getDeclaredMethod("ensureTarget");
				method.setAccessible(true);
				method.invoke(swipeRefreshLayout);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Field field = swipeRefreshLayout.getClass().getDeclaredField("mTarget");
				field.setAccessible(true);
				mTarget = (View) field.get(swipeRefreshLayout);
			} catch (Exception e) {
				e.printStackTrace();
			}
			swipeRefreshLayout.setOnRefreshListener(listener);
		}

		@Override
		public View getContentView() {
			return mTarget;
		}

		@Override
		public View getSwitchView() {
			return swipeRefreshLayout;
		}

		private OnRefreshListener onRefreshListener;

		@Override
		public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
			this.onRefreshListener = onRefreshListener;
		}

		@Override
		public void showRefreshComplete() {
			swipeRefreshLayout.setRefreshing(false);
		}

		@Override
		public void showRefreshing() {
			swipeRefreshLayout.setRefreshing(true);
		}

		private SwipeRefreshLayout.OnRefreshListener listener = new SwipeRefreshLayout.OnRefreshListener() {

			@Override
			public void onRefresh() {
				if (onRefreshListener != null) {
					onRefreshListener.onRefresh();
				}
			}
		};

	}
}
