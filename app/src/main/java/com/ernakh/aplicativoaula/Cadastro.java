package com.ernakh.aplicativoaula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    private EditText editTextNome, editTextIdade, editTextUF, editTextCidade, editTextTelefone, editTextEmail;
    private RadioGroup radioGroupTamanho;
    private CheckBox checkBoxPreto, checkBoxBranco, checkBoxVermelho, checkBoxAzul, checkBoxVerde;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

            // Inicializar componentes
            editTextNome = findViewById(R.id.editTextNome);
            editTextIdade = findViewById(R.id.editTextIdade);
            editTextUF = findViewById(R.id.editTextUF);
            editTextCidade = findViewById(R.id.editTextCidade);
            editTextTelefone = findViewById(R.id.editTextTelefone);
            editTextEmail = findViewById(R.id.editTextEmail);
            radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
            checkBoxPreto = findViewById(R.id.checkBoxPreto);
            checkBoxBranco = findViewById(R.id.checkBoxBranco);
            checkBoxVermelho = findViewById(R.id.checkBoxVermelho);
            checkBoxAzul = findViewById(R.id.checkBoxAzul);
            checkBoxVerde = findViewById(R.id.checkBoxVerde);
            buttonCadastrar = findViewById(R.id.buttonCadastrar);

            // Configurar o botão de cadastro
            buttonCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cadastrarUsuario();
                }
            });
        }

        private void cadastrarUsuario() {
            // Capturar dados dos campos
            String nome = editTextNome.getText().toString();
            String idade = editTextIdade.getText().toString();
            String uf = editTextUF.getText().toString();
            String cidade = editTextCidade.getText().toString();
            String telefone = editTextTelefone.getText().toString();
            String email = editTextEmail.getText().toString();

            // Capturar tamanho selecionado
            int selectedTamanhoId = radioGroupTamanho.getCheckedRadioButtonId();
            RadioButton radioButtonTamanho = findViewById(selectedTamanhoId);
            String tamanho = radioButtonTamanho != null ? radioButtonTamanho.getText().toString() : "";

            // Capturar cores selecionadas
            StringBuilder cores = new StringBuilder();
            if (checkBoxPreto.isChecked()) cores.append("Preto ");
            if (checkBoxBranco.isChecked()) cores.append("Branco ");
            if (checkBoxVermelho.isChecked()) cores.append("Vermelho ");
            if (checkBoxAzul.isChecked()) cores.append("Azul ");
            if (checkBoxVerde.isChecked()) cores.append("Verde ");

            // Exibir mensagem de confirmação
            String mensagem = "Cadastro realizado com sucesso!\n" +
                    "Nome: " + nome + "\n" +
                    "Idade: " + idade + "\n" +
                    "UF: " + uf + "\n" +
                    "Cidade: " + cidade + "\n" +
                    "Telefone: " + telefone + "\n" +
                    "Email: " + email + "\n" +
                    "Tamanho: " + tamanho + "\n" +
                    "Cores Preferidas: " + cores.toString();
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Cadastro.this, MainActivity.class);
            startActivity(intent);
    }
}
