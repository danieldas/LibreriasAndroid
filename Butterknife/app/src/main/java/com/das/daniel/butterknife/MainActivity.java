package com.das.daniel.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvSaludo)TextView _tvSaludo;
    @BindView(R.id.etNombre)EditText _etNombre;
    @BindView(R.id.btnPresionar)Button _btnPresionar;


    @OnClick(R.id.btnPresionar)
    public void Enviar(View view){
        _tvSaludo.setText("Hola "+_etNombre.getText());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
