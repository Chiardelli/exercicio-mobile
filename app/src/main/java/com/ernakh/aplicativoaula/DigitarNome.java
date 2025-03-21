package com.ernakh.aplicativoaula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DigitarNome extends AppCompatActivity {

    private EditText editTextNome;
    private Button btnMostrar;
    private TextView textViewNome;
    private LinearLayout checkboxContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitar_nome);

        editTextNome = findViewById(R.id.editTextNome);
        btnMostrar = findViewById(R.id.btnMostrar);
        textViewNome = findViewById(R.id.textViewNome);
        checkboxContainer = findViewById(R.id.checkboxContainer);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                textViewNome.setText("Nome digitado: " + nome);
                criarCheckboxes(nome);
            }
        });
    }

    public void voltarMain(){
        Intent intent = new Intent(DigitarNome.this, MainActivity.class);
        startActivity(intent);
    }

    private void criarCheckboxes(String nome) {
        checkboxContainer.removeAllViews(); // Limpa os anteriores

        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(String.valueOf(letra));
            checkBox.setId(i);
            checkboxContainer.addView(checkBox);
        }
    }
}