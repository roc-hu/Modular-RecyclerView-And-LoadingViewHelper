package com.lesehome.sample.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lesehome.sample.MainActivity;
import com.lesehome.sample.R;
import com.lesehome.sample.model.Prefs.SplashPrefs;

import java.util.List;

/**
 * 引导页面适配器
 * <p>
 * Created by hcp on 16/1/21.
 */
public class GuideAdapter extends PagerAdapter {

    // 界面列表
    private List<View> views;
    private Activity activity;

    public GuideAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }

    // 销毁arg1位置的界面
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    // 获得当前界面数
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    // 初始化arg1位置的界面
    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1), 0);
        if (arg1 == views.size() - 1) {
            View mVStart = arg0.findViewById(R.id.v_start);
            mVStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 设置已经引导过了，下次启动不用再次引导
                    new SplashPrefs(activity).setNotFirstIn();
                    goHome();

                }

            });
        }
        return views.get(arg1);
    }

    private void goHome() {
        // 跳转
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }

}
