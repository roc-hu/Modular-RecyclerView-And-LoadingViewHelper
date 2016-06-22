package com.lesehome.carrot.loadingview;

import android.content.Context;
import android.view.View;

/**
 * 用于切换布局,用一个新的布局替换掉原先的布局
 * Created by hcp on 16/6/22.
 */
public interface IVaryViewHelper {

    View getCurrentLayout();

    void restoreView();

    void showLayout(View view);

    void showLayout(int layoutId);

    View inflate(int layoutId);

    Context getContext();

    View getView();

}
