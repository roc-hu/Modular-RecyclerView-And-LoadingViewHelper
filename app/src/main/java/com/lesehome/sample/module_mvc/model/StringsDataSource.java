package com.lesehome.sample.module_mvc.model;

import com.lesehome.carrot.loadingview.IDataCacheLoader;
import com.lesehome.carrot.loadingview.IDataSource;
import com.lesehome.sample.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class StringsDataSource implements IDataSource<List<String>>, IDataCacheLoader<List<String>> {
    private int page = 1;
    private int maxPage = 10;

    /**
     * 加载缓存<br>
     * 注意这个方法执行于UI线程，不要做太过耗时的操作<br>
     * 每次刷新的时候触发该方法，该方法在DataSource refresh之前执行<br>
     *
     * @param isEmpty adapter是否有数据，这个值是adapter.isEmpty()决定
     * @return 加载的数据，返回后会执行adapter.notifyDataChanged(data, true)<br>
     * 相当于refresh执行后adapter.notifyDataChanged(data, true)
     */
    @Override
    public List<String> loadCache(boolean isEmpty) {
        if (isEmpty) {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                strings.add("cache  page " + i + "  Java编程思想 ");
            }
            return strings;
        }
        return null;
    }

    @Override
    public List<String> refresh() throws Exception {
        return loadData(1);
    }

    @Override
    public List<String> loadMore() throws Exception {
        return loadData(page + 1);
    }

    private List<String> loadData(int page) throws Exception {
        // 这里用百度首页模拟网络请求，如果网路出错的话，直接抛异常不会执行后面的获取books的语句
        HttpUtils.executeGet("http://www.baidu.com");
        Thread.sleep(1000);
        List<String> strs = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            strs.add("page" + i + "  Java编程思想 ");
        }
        this.page = page;
        return strs;
    }

    @Override
    public boolean hasMore() {
        return page < maxPage;
    }
}
