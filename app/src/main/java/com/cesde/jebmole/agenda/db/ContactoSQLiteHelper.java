package com.cesde.jebmole.agenda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactoSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contactosbd";
    private static final int DATABASE_VERSION = 1;

    public ContactoSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTablaContacto = "CREATE TABLE Contacto\n" +
                "(\n" +
                "\tId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tNombres TEXT,\n" +
                "\tApellidos TEXT,\n" +
                "\tEmail TEXT,\n" +
                "\tDireccion TEXT,\n" +
                "\tTelefono TEXT\n" +
                ")";
        db.execSQL(createTablaContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Contacto");
        onCreate(db);
    }
}
