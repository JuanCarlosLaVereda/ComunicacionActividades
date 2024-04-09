package com.example.comunicacinactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificarActivity extends AppCompatActivity {

    private TextView nombreTextView;
    private Button aceptarButton;
    private Button rechazarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_activity);
        Bundle extras = getIntent().getExtras();


        nombreTextView = findViewById(R.id.textViewNombreVerify);
        aceptarButton = findViewById(R.id.buttonAceptar);
        rechazarButton = findViewById(R.id.buttonRechazar);
        nombreTextView.setText("Hola " + extras.getString("nombre") + ", ¿Aceptas las condiciones?");
        aceptarButton.setOnClickListener(view->lanzarAceptar(view));
        rechazarButton.setOnClickListener(view->lanzarRechazar(view));
    }

    public void lanzarAceptar(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado", "ACEPTADO");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void lanzarRechazar(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado", "RECHAZADO");
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
