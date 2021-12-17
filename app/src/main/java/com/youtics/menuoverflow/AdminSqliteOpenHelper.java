package com.youtics.menuoverflow;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSqliteOpenHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Bitacora.db";
    public static final String TABLE_USUARIOS = "usuarios";
    public static final String TABLE_BUQUES = "buques";

    public AdminSqliteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String consulta = "CREATE TABLE " + TABLE_USUARIOS + " " +
                "(userId TEXT PRIMARY KEY, " +
                "pass TEXT, " +
                "statusLogin TEXT, " +
                "registerDate TEXT)";
        db.execSQL(consulta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String consulta = "DROP TABLE "  + TABLE_USUARIOS;
        db.execSQL(consulta);
        onCreate(db);
    }
}
