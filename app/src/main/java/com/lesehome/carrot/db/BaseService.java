package com.lesehome.carrot.db;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by hcp on 16/3/28.
 */
public class BaseService<T, K> {
    private AbstractDao<T, K> mDao;


    public BaseService(AbstractDao dao) {
        mDao = dao;
    }


    public void save(T item) {
        mDao.insert(item);
    }

    public void save(T... items) {
        mDao.insertInTx(items);
    }

    public void save(List<T> items) {
        mDao.insertInTx(items);
    }

    public void saveOrUpdate(T item) {
        mDao.insertOrReplace(item);
    }

    public void saveOrUpdate(T... items) {
        mDao.insertOrReplaceInTx(items);
    }

    public void saveOrUpdate(List<T> items) {
        mDao.insertOrReplaceInTx(items);
    }

    public void deleteByKey(K key) {
        mDao.deleteByKey(key);
    }

    public void delete(T item) {
        mDao.delete(item);
    }

    public void delete(T... items) {
        mDao.deleteInTx(items);
    }

    public void delete(List<T> items) {
        mDao.deleteInTx(items);
    }

    public void deleteAll() {
        mDao.deleteAll();
    }


    public void update(T item) {
        mDao.update(item);
    }

    public void update(T... items) {
        mDao.updateInTx(items);
    }

    public void update(List<T> items) {
        mDao.updateInTx(items);
    }

    public  T query(K key) {
        return  mDao.load(key);
    }

    public List<T> queryAll() {
        return mDao.loadAll();
    }

    public List<T> query(String where, String... params) {

        return mDao.queryRaw(where, params);
    }

    public QueryBuilder<T> queryBuilder() {
        return mDao.queryBuilder();
    }

    public long count() {
        return mDao.count();
    }

    public void refresh(T item) {
        mDao.refresh(item);

    }

    public void detach(T item) {
        mDao.detach(item);
    }
}
