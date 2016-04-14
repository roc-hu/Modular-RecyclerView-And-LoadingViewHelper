package com.lesehome.carrot.db;

import com.lesehome.greendao.dao.NoteDao;

/**
 * Created by hcp on 16/3/28.
 */
public class DbUtil {
    private static NoteService noteService;

    private static NoteDao getNoteDao() {
        return MyDb.getDaoSession().getNoteDao();
    }

    public static NoteService getNoteService() {
        if (noteService == null) {
            noteService = new NoteService(getNoteDao());
        }
        return noteService;
    }
}
