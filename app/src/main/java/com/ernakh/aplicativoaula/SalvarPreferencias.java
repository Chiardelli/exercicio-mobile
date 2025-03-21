package com.ernakh.aplicativoaula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SalvarPreferencias extends AppCompatActivity {

    private CheckBox checkNotificacoes, checkModoEscuro, checkLembrarLogin;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_preferencias);

        checkNotificacoes = findViewById(R.id.checkNotificacoes);
        checkModoEscuro = findViewById(R.id.checkModoEscuro);
        checkLembrarLogin = findViewById(R.id.checkLembrarLogin);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPreferencias();
            }
        });
    }

    private void salvarPreferencias() {
        StringBuilder mensagem = new StringBuilder();

        if (checkNotificacoes.isChecked()) {
            mensagem.append("Receber notificações\n");
        }
        if (checkModoEscuro.isChecked()) {
            mensagem.append("Modo escuro\n");
        }
        if (checkLembrarLogin.isChecked()) {
            mensagem.append("Lembrar login\n");
        }

        if (mensagem.length() == 0) {
            mensagem.append("Nenhuma preferência foi escolhida");
        }

        Toast.makeText(this, mensagem.toString().trim(), Toast.LENGTH_SHORT).show();
    }

    public void voltarMain(){
        Intent intent = new Intent(SalvarPreferencias.this, MainActivity.class);
        startActivity(intent);
    }
}