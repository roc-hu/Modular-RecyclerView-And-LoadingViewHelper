package com.lesehome.sample.module_mvc.model;

import java.util.ArrayList;
import java.util.List;

import com.lesehome.carrot.loadingview.IDataSource;
import com.lesehome.carrot.loadingview.data.Data3;
import com.lesehome.sample.module_mvc.model.entity.Discuss;
import com.lesehome.sample.module_mvc.model.entity.Movie;
import com.lesehome.sample.module_mvc.model.entity.Other;
import com.lesehome.sample.utils.HttpUtils;

public class MovieDetailDataSource implements IDataSource<Data3<Movie, List<Discuss>, List<Other>>> {

    private int bookPage = 0;
    private int maxBookPage = 3;

    private int otherPage = 0;
    private int maxmoviePage = 2;

    @Override
    public Data3<Movie, List<Discuss>, List<Other>> refresh() throws Exception {
        Movie value1 = new Movie("海贼王第23集", 67.0,
                "哲普的出现，揭露了他和克利克都到过伟大的航路的事实，从阿金口中得知他们在伟大的航路碰上一个神秘的男人，他竟独力打败了五十艘海贼船，而就在克利克为抢夺哲普的航海日记及海上餐厅这艘船时，传说中鹰眼的男人出现了", "00:30");
        Data3<Movie, List<Discuss>, List<Other>> data = new Data3<Movie, List<Discuss>, List<Other>>(
                value1, loadDiscuss(1), null);
        bookPage = 1;
        otherPage = 0;
        return data;
    }

    @Override
    public Data3<Movie, List<Discuss>, List<Other>> loadMore() throws Exception {
        if (bookPage < maxBookPage) {
            return new Data3<>(null, loadDiscuss(bookPage + 1), null);
        } else {
            return new Data3<>(null, null, loadOther(otherPage + 1));
        }
    }

    private List<Discuss> loadDiscuss(int page) throws Exception {
        // 这里用百度首页模拟网络请求，如果网路出错的话，直接抛异常不会执行后面的获取books的语句
        HttpUtils.executeGet("http://www.baidu.com");
        Thread.sleep(1000);

        List<Discuss> discusss = new ArrayList<Discuss>();
        for (int i = 0; i < 10; i++) {
            discusss.add(new Discuss("", "page" + page + ": Discuss " + ((page - 1) * 10 + i+1), System.currentTimeMillis()));
        }
        this.bookPage = page;
        return discusss;
    }

    private List<Other> loadOther(int page) throws Exception {
        // 这里用百度首页模拟网络请求，如果网路出错的话，直接抛异常不会执行后面的获取books的语句
        HttpUtils.executeGet("http://www.baidu.com");
        Thread.sleep(1000);

        List<Other> others = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            others.add(new Other("Other:海贼王->" + page + "页", ((page - 1) * 10 + i+1), "00:3" + i));
        }
        this.otherPage = page;
        return others;
    }

    @Override
    public boolean hasMore() {
        if (bookPage < maxBookPage) {
            return true;
        }
        if (otherPage < maxmoviePage) {
            return true;
        }
        return false;
    }

}
