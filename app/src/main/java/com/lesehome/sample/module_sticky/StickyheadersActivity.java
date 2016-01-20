package com.lesehome.sample.module_sticky;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lesehome.carrot.loadingview.IDataAdapter;
import com.lesehome.carrot.loadingview.IDataSource;
import com.lesehome.carrot.loadingview.helper.LoadingViewNormalHelper;
import com.lesehome.sample.R;

import com.lesehome.sample.module_sticky.controller.DoubleHeaderFragment;
import com.lesehome.sample.module_sticky.controller.InlineStickyHeaderFragment;
import com.lesehome.sample.module_sticky.controller.StickyHeaderFragment;


public class StickyheadersActivity extends FragmentActivity {
    private LoadingViewNormalHelper<String> helper;

    private ViewPager pager;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stickyheaders_activity_main);
        pager = (ViewPager) this.findViewById(R.id.pager);
        fragmentManager = this.getSupportFragmentManager();

        helper = new LoadingViewNormalHelper<String>(findViewById(R.id.fl));
        helper.setDataSource(dataSource);
        helper.setAdapter(dataAdapter);
        helper.refresh();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.destory();
    }

    private IDataSource<String> dataSource = new IDataSource<String>() {
        @Override
        public String refresh() throws Exception {
            Thread.sleep(2000);
            return "refresh";
        }

        @Override
        public String loadMore() throws Exception {
            return null;
        }

        @Override
        public boolean hasMore() {
            return false;
        }
    };

    private IDataAdapter<String> dataAdapter = new IDataAdapter<String>() {
        String data = null;

        @Override
        public void notifyDataChanged(String data, boolean isRefresh) {
            this.data = data;
            HeaderPagerAdapter adapter = new HeaderPagerAdapter(fragmentManager);
            pager.setAdapter(adapter);
        }

        @Override
        public boolean isEmpty() {
            return data == null;
        }

        @Override
        public String getData() {
            return data;
        }
    };

    class HeaderPagerAdapter extends FragmentPagerAdapter {

        public HeaderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new StickyHeaderFragment();

                case 1:
                    return new InlineStickyHeaderFragment();

                case 2:
                    return new DoubleHeaderFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Sticky Header";

                case 1:
                    return "Sticky Header - Inline";

                case 2:
                    return "Double Header";

                default:
                    return null;
            }
        }
    }
}
