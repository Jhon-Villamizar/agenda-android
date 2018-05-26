package com.cesde.jebmole.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle params = getIntent().getExtras();
        String nombre = params.getString("pNombre");
        String telefono = params.getString("pTelefono");
        String email = params.getString("pEmail");

        TextView tvNombre = (TextView)findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView)findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }
}
