package com.liqy.douyin.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.liqy.douyin.entity.Music;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MUSIC".
*/
public class MusicDao extends AbstractDao<Music, Long> {

    public static final String TABLENAME = "MUSIC";

    /**
     * Properties of entity Music.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Pid = new Property(0, long.class, "pid", true, "_id");
        public final static Property Author = new Property(1, String.class, "author", false, "AUTHOR");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
    }


    public MusicDao(DaoConfig config) {
        super(config);
    }
    
    public MusicDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MUSIC\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: pid
                "\"AUTHOR\" TEXT," + // 1: author
                "\"TITLE\" TEXT);"); // 2: title
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MUSIC\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Music entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPid());
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(2, author);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Music entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPid());
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(2, author);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Music readEntity(Cursor cursor, int offset) {
        Music entity = new Music( //
            cursor.getLong(offset + 0), // pid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // author
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // title
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Music entity, int offset) {
        entity.setPid(cursor.getLong(offset + 0));
        entity.setAuthor(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Music entity, long rowId) {
        entity.setPid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Music entity) {
        if(entity != null) {
            return entity.getPid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Music entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}