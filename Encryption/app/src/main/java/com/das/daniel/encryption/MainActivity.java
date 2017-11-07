package com.das.daniel.encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ru.bullyboo.encoder.Encoder;
import ru.bullyboo.encoder.callbacks.EncodeCallback;
import ru.bullyboo.encoder.methods.AES;

public class MainActivity extends AppCompatActivity {

    TextView _tvEncriptado, _tvDesencriptado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _tvEncriptado= (TextView) findViewById(R.id.tvEncriptado);
        _tvDesencriptado= (TextView) findViewById(R.id.tvDesencriptado);

        String encriptado = Encoder.BuilderAES()
                .message("Android Camp")
                .method(AES.Method.AES_CBC_PKCS5PADDING)
                .key("test key")
                .keySize(AES.Key.SIZE_128)
                .iVector("test vector")
                .encrypt();

        String desencriptado = Encoder.BuilderAES()
                .message(encriptado)
                .method(AES.Method.AES_CBC_PKCS5PADDING)
                .key("test key")
                .keySize(AES.Key.SIZE_128)
                .iVector("test vector")
                .decrypt();

        _tvEncriptado.setText(encriptado);
        _tvDesencriptado.setText(desencriptado);


    }
}
