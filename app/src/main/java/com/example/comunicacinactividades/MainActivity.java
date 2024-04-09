package com.example.comunicacinactividades;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button verificarButton;
    private EditText nombreEditText;
    //private ActivityResultLauncher resoultLauncher;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificarButton = findViewById(R.id.buttonVerificar);
        nombreEditText = findViewById(R.id.editTextNombre);
        resultadoTextView = findViewById(R.id.textViewResultado);

        ActivityResultLauncher resoultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK || result.getResultCode() == Activity.RESULT_CANCELED) {
                        Intent data = result.getData();
                        String info = result.getData().getExtras().getString("resultado");
                        resultadoTextView.setText("Resultado -> " + info);
                    } else {
                        resultadoTextView.setText("Algo ha salido mal");
                    }
                }
            );
        verificarButton.setOnClickListener(view ->{
            if (nombreEditText.getText().toString().equals("")){
                Toast.makeText(this, "El nombre no puede estar vacio", Toast.LENGTH_SHORT).show();

            } else {
                Intent intent = new Intent(this, VerificarActivity.class);
                intent.putExtra("nombre", nombreEditText.getText().toString());
                resoultLauncher.launch(intent);
            }
        });

    }
}