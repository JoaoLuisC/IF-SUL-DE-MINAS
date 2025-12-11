package br.edu.ifsuldeminas.mch.controlefinanceiro.model.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAO {
    private static DBHandler dbHandler = null;

    DAO(Context context) {
        if (dbHandler == null)
            dbHandler = new DBHandler(context);
    }

    SQLiteDatabase openToWrite() throws SQLException {
        return dbHandler.getWritableDatabase();
    }

    SQLiteDatabase openToRead() throws SQLException {
        return dbHandler.getReadableDatabase();
    }
}

