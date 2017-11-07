package com.das.daniel.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    String datosFormatoJson = "{\"nombre\":\"Daniel\",\"apellido\":\"Ojalvo Canedo\",\"celular\":72464162,\"profesion\":\"Ingeniero Informatico\",\"correo\":\"daniel-sj77@hotmail.com\"}";
    Gson gson = new Gson();
    TextView _tvNombre, _tvApellido, _tvCelular, _tvProfesion, _tvCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        String json = datosFormatoJson;
        Persona persona = gson.fromJson(json,Persona.class);

        _tvNombre.setText("Nombre: "+persona.nombre);
        _tvApellido.setText("Apellido: "+persona.apellido);
        _tvCelular.setText("Celular: "+persona.celular);
        _tvProfesion.setText("Profesión: "+persona.profesion);
        _tvCorreo.setText("Correo: "+persona.correo);

    }

    private  void inicializarComponentes()
    {
        _tvNombre= (TextView) findViewById(R.id.tvNombre);
        _tvApellido= (TextView) findViewById(R.id.tvApellido);
        _tvCelular= (TextView) findViewById(R.id.tvCelular);
        _tvProfesion= (TextView) findViewById(R.id.tvProfesion);
        _tvCorreo= (TextView) findViewById(R.id.tvCorreo);
    }
}
