package com.ernakh.aplicativoaula;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("CicloDeVida", "onCreate() chamado");

        if (savedInstanceState != null) {
            // Restaura os valores do estado salvo
            int mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
            int mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
        } else {
            // inicializa as variáveis com valores padrão
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void carregarUsuarioActivity(View view) {
        Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
        startActivity(intent);
    }

    public void carregarCalculadoraActivity(View view){
        Intent intent = new Intent(MainActivity.this, Calculadora.class);
        startActivity(intent);
    }

    public void carregarCadastraoActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Cadastro.class);
        startActivity(intent);
    }

    public void carregarDigitarNomeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, DigitarNome.class);
        startActivity(intent);
    }

    public void carregarSalvarPreferenciaActivity(View view){
        Intent intent = new Intent(MainActivity.this, SalvarPreferencias.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("CicloDeVida", "onSaveInstanceState() chamado");

        // Salva o estado atual do jogador
        savedInstanceState.putInt(STATE_SCORE, 100);
        savedInstanceState.putInt(STATE_LEVEL, 1);
        // Invoca a super classe, para que seja possível salvar o estado
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("CicloDeVida", "onStart() chamado");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("CicloDeVida", "onRestart() chamado");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("CicloDeVida", "onResume() chamado");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("CicloDeVida", "onPause() chamado");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("CicloDeVida", "onStop() chamado");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("CicloDeVida", "onDestroy() chamado");
    }
}