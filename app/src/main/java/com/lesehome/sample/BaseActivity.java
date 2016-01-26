package com.lesehome.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by hcp on 16/1/18.
 */
public class BaseActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = BaseApp.getRefWatcher();
        refWatcher.watch(this);
    }

    /**
     * 查找页面view
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
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
