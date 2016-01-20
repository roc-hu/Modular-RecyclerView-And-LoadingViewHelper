package com.lesehome.sample.module_mvc.model;

import com.lesehome.carrot.loadingview.IDataSource;
import com.lesehome.sample.module_mvc.model.entity.Book;
import com.lesehome.sample.utils.HttpUtils;

public class NormalDataSource implements IDataSource<Book> {

    @Override
    public Book refresh() throws Exception {
        // 这里用百度首页模拟网络请求，如果网路出错的话，直接抛异常不会执行后面的获取books的语句
        HttpUtils.executeGet("http://www.baidu.com");
        Thread.sleep(1000);
        String name = "设计模式之禅";
        double price = 12.00;
        String author = "秦小波";
        String description = "如果说“四人帮”的《设计模式》是设计模式领域的“圣经”，那么之后出版的各种关于设计模式的书都可称之为“圣经”的“注释版”或“圣经的故事”。《设计模式之禅》是得道者对“圣经”的“禅悟”，它既不像“圣经”那样因为惜字如金、字字珠玑而深奥、晦涩和难懂，又比“圣经”的“注释版”更深刻和全面、更通俗和生动、更接近开发者遇到的实践场景，更具指导性";
        String content = "第一部分　大旗不挥，谁敢冲锋 ——6大设计原则\n全新解读\n第1章　单一职责原则\n第2章　里氏替换原则\n第3章　依赖倒置原则\n第4章　接口隔离原则\n第5章　迪米特法则\n第6章　开闭原则 \n第一部分　大旗不挥，谁敢冲锋 ——6大设计原则\n" +
                "全新解读\n" +
                "第1章　单一职责原则\n" +
                "第2章　里氏替换原则\n" +
                "第3章　依赖倒置原则\n" +
                "第4章　接口隔离原则\n" +
                "第5章　迪米特法则\n" +
                "第6章　开闭原则";
        return new Book(name, price, author, description, content);
    }

    @Override
    public Book loadMore() throws Exception {
        return null;
    }

    @Override
    public boolean hasMore() {
        return false;
    }

}
