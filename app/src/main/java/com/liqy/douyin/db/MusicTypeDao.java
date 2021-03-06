package com.liqy.douyin.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.liqy.douyin.entity.MusicType;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MUSIC_TYPE".
*/
public class MusicTypeDao extends AbstractDao<MusicType, String> {

    public static final String TABLENAME = "MUSIC_TYPE";

    /**
     * Properties of entity MusicType.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id_str = new Property(0, String.class, "id_str", true, "ID_STR");
        public final static Property Mc_name = new Property(1, String.class, "mc_name", false, "MC_NAME");
    }


    public MusicTypeDao(DaoConfig config) {
        super(config);
    }
    
    public MusicTypeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MUSIC_TYPE\" (" + //
                "\"ID_STR\" TEXT PRIMARY KEY NOT NULL ," + // 0: id_str
                "\"MC_NAME\" TEXT);"); // 1: mc_name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MUSIC_TYPE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MusicType entity) {
        stmt.clearBindings();
 
        String id_str = entity.getId_str();
        if (id_str != null) {
            stmt.bindString(1, id_str);
        }
 
        String mc_name = entity.getMc_name();
        if (mc_name != null) {
            stmt.bindString(2, mc_name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MusicType entity) {
        stmt.clearBindings();
 
        String id_str = entity.getId_str();
        if (id_str != null) {
            stmt.bindString(1, id_str);
        }
 
        String mc_name = entity.getMc_name();
        if (mc_name != null) {
            stmt.bindString(2, mc_name);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public MusicType readEntity(Cursor cursor, int offset) {
        MusicType entity = new MusicType( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id_str
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // mc_name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MusicType entity, int offset) {
        entity.setId_str(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setMc_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(MusicType entity, long rowId) {
        return entity.getId_str();
    }
    
    @Override
    public String getKey(MusicType entity) {
        if(entity != null) {
            return entity.getId_str();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MusicType entity) {
        return entity.getId_str() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
