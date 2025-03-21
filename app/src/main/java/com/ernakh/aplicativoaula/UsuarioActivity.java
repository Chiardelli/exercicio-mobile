package com.ernakh.aplicativoaula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        EditText edtNome = findViewById(R.id.nome);
        EditText edtIdade = findViewById(R.id.idade);
        Button btnVerificar = findViewById(R.id.btnVerificar);
        TextView txtResultado = findViewById(R.id.txtResultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNome.getText().toString();
                String idadeStr = edtIdade.getText().toString();

                if (nome.isEmpty() || idadeStr.isEmpty()) {
                    txtResultado.setText("Por favor, preencha todos os campos.");
                    return;
                }

                int idade = Integer.parseInt(idadeStr);

                if (idade >= 18) {
                    txtResultado.setText(nome + ", você é maior de idade.");
                } else {
                    txtResultado.setText(nome + ", você é menor de idade.");
                }
            }
        });
    }

    public void voltarMain(){
        Intent intent = new Intent(UsuarioActivity.this, MainActivity.class);
        startActivity(intent);
    }
}