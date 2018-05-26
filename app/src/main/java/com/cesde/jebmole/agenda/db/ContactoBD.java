package com.cesde.jebmole.agenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cesde.jebmole.agenda.Contacto;

import java.util.ArrayList;

public class ContactoBD {

    private ContactoSQLiteHelper sqLiteHelper;
    private SQLiteDatabase database;

    public ContactoBD(Context context){
        sqLiteHelper = new ContactoSQLiteHelper(context);
        database = sqLiteHelper.getWritableDatabase();
    }

    public long InsertarContacto(Contacto contacto){

        ContentValues values = new ContentValues();
        values.put("Nombres", contacto.getNombres());
        values.put("Apellidos", contacto.getApellidos());
        values.put("Email", contacto.getEmail());
        values.put("Direccion", contacto.getDireccion());
        values.put("Telefono", contacto.getTelefono());

        return database.insert("Contacto", null, values);
    }

    public ArrayList<Contacto> ObtenerContactos(){

        ArrayList<Contacto> contactos = new ArrayList<>();
        String query = "SELECT * FROM Contacto";

        Cursor registros = database.rawQuery(query, null);
        while(registros.moveToNext()){

            Contacto contacto = new Contacto();
            contacto.setId(registros.getInt(0));
            contacto.setNombres(registros.getString(1));
            contacto.setApellidos(registros.getString(2));
            contacto.setEmail(registros.getString(3));
            contacto.setDireccion(registros.getString(4));
            contacto.setTelefono(registros.getString(5));

            contactos.add(contacto);
        }

        return  contactos;
    }

}
