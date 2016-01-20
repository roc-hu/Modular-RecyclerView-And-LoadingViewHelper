package com.lesehome.sample;

import android.app.Fragment;
import android.view.View;

/**
 * Created by hcp on 16/1/18.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

    /**
     * 查找页面view
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findView(int id) {
        return (T) getView().findViewById(id);
    }

    /**
     * 设置View的OnClickListener
     *
     * @param views
     */
    protected void setOnClickListener(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
