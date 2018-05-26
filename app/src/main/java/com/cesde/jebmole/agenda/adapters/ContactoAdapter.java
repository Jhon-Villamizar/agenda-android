package com.cesde.jebmole.agenda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cesde.jebmole.agenda.Contacto;
import com.cesde.jebmole.agenda.R;

import java.util.ArrayList;

public class ContactoAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Contacto> contactos;

    public ContactoAdapter(Context context, int layout, ArrayList<Contacto> contactos){
        this.context = context;
        this.layout = layout;
        this.contactos = contactos;
    }


    @Override
    public int getCount() {
        return this.contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contactos.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = view;

        LayoutInflater inflater = LayoutInflater.from(this.context);
        v = inflater.inflate(R.layout.item_contacto, null);

        Contacto contacto = this.contactos.get(position);
        String nombre = contacto.getNombres() + " " + contacto.getApellidos();
        String telefono = contacto.getTelefono();

        TextView tvNombre = v.findViewById(R.id.tvNombre);
        TextView tvTelefono = v.findViewById(R.id.tvTelefono);
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);

        return v;
    }
}
