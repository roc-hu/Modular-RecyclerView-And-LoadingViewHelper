package com.lesehome.carrot.loadingview.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesehome.carrot.loadingview.IVaryViewHelper;

/**
 * 用于切换布局,用一个新的布局替换掉原先的布局
 */
public class VaryViewHelper implements IVaryViewHelper {
    private View originalView;
    private ViewGroup parentView;
    private int viewIndex;
    private ViewGroup.LayoutParams originalParams;
    private ViewGroup.LayoutParams selfParams;
    private View currentView;

    public VaryViewHelper(View view) {
        super();
        this.originalView = view;
    }

    /**
     * @param view
     * @param selfParams 替换view的时候用selfParams设置，originalView依然使用originalParams设置
     */
    public VaryViewHelper(View view, ViewGroup.LayoutParams selfParams) {
        super();
        this.originalView = view;
        this.selfParams = selfParams;
    }

    private void init() {
        originalParams = originalView.getLayoutParams();
        if (originalView.getParent() != null) {
            parentView = (ViewGroup) originalView.getParent();
        } else {
            parentView = (ViewGroup) originalView.getRootView().findViewById(android.R.id.content);
        }
        int count = parentView.getChildCount();
        for (int index = 0; index < count; index++) {
            if (originalView == parentView.getChildAt(index)) {
                viewIndex = index;
                break;
            }
        }
        currentView = originalView;
    }

    @Override
    public View getCurrentLayout() {
        return currentView;
    }

    @Override
    public void restoreView() {
        showLayout(originalView);
    }

    @Override
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
            if (view != originalView && selfParams != null) {
                parentView.addView(view, viewIndex, selfParams);
            } else {
                parentView.addView(view, viewIndex, originalParams);
            }
        }
    }

    @Override
    public void showLayout(int layoutId) {
        showLayout(inflate(layoutId));
    }

    @Override
    public View inflate(int layoutId) {
        return LayoutInflater.from(originalView.getContext()).inflate(layoutId, null);
    }

    @Override
    public Context getContext() {
        return originalView.getContext();
    }

    @Override
    public View getView() {
        return originalView;
    }
}
