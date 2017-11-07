package com.das.daniel.customtoast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tree.rh.ctlib.CT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button _btnExito, _btnFallo, _btnCargando, _btnSilencio, _btnNormal, _btnPersonalizable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnExito= (Button) findViewById(R.id.btnExito);
        _btnFallo= (Button) findViewById(R.id.btnFallo);
        _btnCargando= (Button) findViewById(R.id.btnCargando);
        _btnSilencio= (Button) findViewById(R.id.btnSilencio);
        _btnNormal= (Button) findViewById(R.id.btnNormal);
        _btnPersonalizable= (Button) findViewById(R.id.btnPersonalizable);

        _btnExito.setOnClickListener(this);
        _btnFallo.setOnClickListener(this);
        _btnCargando.setOnClickListener(this);
        _btnSilencio.setOnClickListener(this);
        _btnNormal.setOnClickListener(this);
        _btnPersonalizable.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case (R.id.btnExito):
                CT.success(this, "Se realizó con éxito");
                break;
            case (R.id.btnFallo):
                CT.failed(this, "Ha ocurrido un error");
                break;
            case (R.id.btnSilencio):
                CT.mute(this, "Silencio");
                break;
            case (R.id.btnCargando):
                CT.loading(this, "Cargando, espere por favor");
                break;
            case (R.id.btnNormal):
                CT.normal(this, "Hola mundo");
                break;
            case (R.id.btnPersonalizable):
                new CT.Builder(this, "Mensaje personalizado")
                        .textCol(Color.BLUE)
                        .backCol(Color.YELLOW)
                        .borderCol(Color.BLUE)
                        .borderWidth(20)
                        .image(R.mipmap.ic_launcher)
                        .gravity(Gravity.CENTER)
                        .radius(80,0,0,80)
                        .duration(Toast.LENGTH_LONG)
                        .show();
                break;
        }
    }
}
