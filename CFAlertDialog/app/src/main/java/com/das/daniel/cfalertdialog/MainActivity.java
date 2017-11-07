package com.das.daniel.cfalertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crowdfireapp.cfalertdialog.CFAlertDialog;

public class MainActivity extends AppCompatActivity {

    private Button _btnNormal, _btnEligeUno, _btnEligeVarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnNormal= (Button) findViewById(R.id.btnNormal);
        _btnEligeUno= (Button) findViewById(R.id.btnEligeUno);
        _btnEligeVarios= (Button) findViewById(R.id.btnEligeVarios);

        _btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normal();
            }
        });
        _btnEligeUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eligeUno();
            }
        });
        _btnEligeVarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eligeVarios();
            }
        });

    }
    private void eligeUno ()
    {
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this);
        builder.setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT);
        builder.setTitle("Selecciona un color de fondo");
        builder.setSingleChoiceItems(new String[]{"Azul", "Amarillo", "Negro", "Blanco", "Verde", "Rojo"}, 3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                Toast.makeText(MainActivity.this, "Seleccionado: "+index, Toast.LENGTH_SHORT).show();
            }
        });
        builder.addButton("Elegir", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void eligeVarios(){
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this);
        builder.setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT);
        builder.setMessage("Selecciona tus lenguajes de programación favoritos");
        builder.setMultiChoiceItems(new String[]{"C#", "Java", "Php", "Python", "Kotlin", "Javascript"}, new boolean[]{false, false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index, boolean b) {
                Toast.makeText(MainActivity.this, "Fila:"+index+" "+(b? "Seleccionada":"Unselected"), Toast.LENGTH_SHORT).show();
            }
        });
        builder.addButton("Siguiente", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }

    private void normal(){

        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTitle("Actualización")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Esta aplicación necesita ser actualizada para su correcto funcionamiento")
                .addButton("Actualizar", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE,
                        CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        builder.show();

    }
}
