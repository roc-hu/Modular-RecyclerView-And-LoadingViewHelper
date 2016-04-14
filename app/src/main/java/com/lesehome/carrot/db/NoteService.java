package com.lesehome.carrot.db;

import com.lesehome.greendao.bean.Note;
import com.lesehome.greendao.dao.NoteDao;

/**
 * Created by hcp on 16/3/28.
 */
public class NoteService extends BaseService<Note,Long> {
    public NoteService(NoteDao dao) {
        super(dao);
    }
}
