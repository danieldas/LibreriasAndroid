package com.das.daniel.saripaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  Validator.ValidationListener{

    private Button _btnGuardar;

    @NotEmpty(message = "Ingrese su nombre")
    @Pattern(regex ="[a-z A-Z Ñ ñ Á-Ú á-ú Ü ü]{3,50}",
            message = "Ingrese sólo letras, rango: 3-50")
    private EditText _etNombre;

    @NotEmpty(message = "Ingrese su apellido")
    @Pattern(regex ="[a-z A-Z Ñ ñ Á-Ú á-ú Ü ü]{3,50}",
            message = "Ingrese sólo letras, rango: 3-50")
    private EditText _etApellido;

    @NotEmpty(message = "Ingrese su Teléfono")
    @Pattern(regex ="[0-9]{5,8}",message = "Ingrese sólo números, rango 5-8")
    private EditText _etTelefono;

    @NotEmpty(message = "Ingrese su correo")
    @Email(message = "Correo inválido")
    private EditText _etCorreo;

    @NotEmpty(message = "Ingrese su Cuenta")
    @Pattern(regex ="[A-Z]{4}[0-9]{3}",message = "Formato incorrecto")
    private EditText _etUsuario;


    Validator validator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validator = new Validator(this);
        validator.setValidationListener(this);
        inicializarComponente();

        _btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });
    }

    private void  inicializarComponente()
    {
        _btnGuardar= (Button) findViewById(R.id.btnGuardar);
        _etNombre= (EditText) findViewById(R.id.etNombre);
        _etApellido= (EditText) findViewById(R.id.etApellido);
        _etTelefono= (EditText) findViewById(R.id.etTelefono);
        _etCorreo= (EditText) findViewById(R.id.etCorreo);
        _etUsuario= (EditText) findViewById(R.id.etUsuario);
    }
    @Override
    public void onValidationSucceeded() {
        Toast.makeText(MainActivity.this, "Registros guardados correctamente", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for(ValidationError error : errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText){
                ((EditText) view).setError(message);
            }
        }
    }
}
