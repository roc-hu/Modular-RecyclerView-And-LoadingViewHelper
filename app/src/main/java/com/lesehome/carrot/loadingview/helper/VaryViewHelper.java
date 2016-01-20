package com.lesehome.carrot.loadingview.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 用于切换布局,用一个新的布局替换掉原先的布局
 */
public class VaryViewHelper{
	private View view;
	private ViewGroup parentView;
	private int viewIndex;
	private ViewGroup.LayoutParams params;
	private View currentView;

	public VaryViewHelper(View view) {
		super();
		this.view = view;
	}

	/**
	 * 初始化
	 */
	private void init() {
		params = view.getLayoutParams();
		if (view.getParent() != null) {
			parentView = (ViewGroup) view.getParent();
		} else {
			parentView = (ViewGroup) view.getRootView().findViewById(android.R.id.content);
		}
		int count = parentView.getChildCount();
		for (int index = 0; index < count; index++) {
			if (view == parentView.getChildAt(index)) {
				viewIndex = index;
				break;
			}
		}
		currentView = view;
	}

	/**
	 * 获取当前的布局
	 * @return
     */
	public View getCurrentLayout() {
		return currentView;
	}

	/**
	 * 复原View
	 */
	public void restoreView() {
		showLayout(view);
	}

	/**
	 * 展示布局
	 * @param view
     */
	public void showLayout(View view) {
		if (parentView == null) {
			init();
		}
		this.currentView = view;
		// 如果已经是那个view，那就不需要再进行替换操作了
		if (parentView.getChildAt(viewIndex) != view) {
			ViewGroup parent = (ViewGroup) view.getParent();
			if (parent != null) {
				parent.removeView(view);
			}
			parentView.removeViewAt(viewIndex);
			parentView.addView(view, viewIndex, params);
		}
	}

	/**
	 * 展示布局
	 * @param layoutId
     */
	public void showLayout(int layoutId) {
		showLayout(inflate(layoutId));
	}

	/**
	 * 通过布局资源ID 加载布局
	 * @param layoutId
	 */
	public View inflate(int layoutId) {
		return LayoutInflater.from(view.getContext()).inflate(layoutId, null);
	}

	/**
	 *
	 * @return Context
     */
	public Context getContext() {
		return view.getContext();
	}

	/**
	 *
	 * @return View
	 */
	public View getView() {
		return view;
	}
}
