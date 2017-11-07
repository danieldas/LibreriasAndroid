package com.das.daniel.qrgenerator;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class MainActivity extends AppCompatActivity {

    EditText _etTexto;
    ImageView _imgQR;
    Button _btnGenerar, _btnGuardar;
    String textoAConvertir;
    String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _imgQR = (ImageView) findViewById(R.id.imgQR);
        _etTexto = (EditText) findViewById(R.id.etTexto);
        _btnGenerar = (Button) findViewById(R.id.btnGenerar);
        _btnGuardar = (Button) findViewById(R.id.btnGuardar);

        _btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoAConvertir = _etTexto.getText().toString().trim();
                if (textoAConvertir.length() > 0)
                {
                    qrgEncoder = new QRGEncoder(textoAConvertir, null,
                            QRGContents.Type.TEXT, 1000);
                    try
                    {
                        bitmap = qrgEncoder.encodeAsBitmap();
                        _imgQR.setImageBitmap(bitmap);
                    }
                    catch (WriterException e)
                    {
                        Toast.makeText(MainActivity.this, "Error: " + e, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Llene la caja de texto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        _btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean save;
                String result;
                try {
                    save = QRGSaver.save(savePath, _etTexto.getText().toString().trim(), bitmap, QRGContents.ImageType.IMAGE_JPEG);
                    result = save ? "Imagen guardada" : "Imagen no guardada";
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
