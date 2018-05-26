package com.cesde.jebmole.agenda;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cesde.jebmole.agenda.adapters.ContactoAdapter;
import com.cesde.jebmole.agenda.db.ContactoBD;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CargarContactos();

        ListView lvContactos = (ListView)findViewById(R.id.lvContactos);
        ContactoAdapter adapter = new ContactoAdapter(this, R.layout.item_contacto, listaContactos);
        lvContactos.setAdapter(adapter);

        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                Contacto seleccionado = listaContactos.get(posicion);
                Intent detalle = new Intent(MainActivity.this, DetalleContacto.class);
                detalle.putExtra("pNombre", seleccionado.getNombres() + " " + seleccionado.getApellidos());
                detalle.putExtra("pTelefono", seleccionado.getTelefono());
                detalle.putExtra("pEmail", seleccionado.getEmail());
                startActivity(detalle);
            }
        });

        registerForContextMenu(lvContactos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnNuevo:
                Toast.makeText(this,"Ha presionado NUevo", Toast.LENGTH_LONG).show();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_items, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.ctxEditar:
                Toast.makeText(this,"Ha presionado Editar", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }



    }

    private void CargarContactos(){

        ContactoBD bd = new ContactoBD(this);
        listaContactos = bd.ObtenerContactos();

    }
}
