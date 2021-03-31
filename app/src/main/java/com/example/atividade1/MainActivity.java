package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtSenha;
    Button btnLogar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogar = findViewById(R.id.btnLogar);

        context = MainActivity.this;

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = txtUsuario.getText().toString();
                String senha = txtSenha.getText().toString();

                if(usuario.equals("augusto") && senha.equals("123")){
                    Intent tela = new Intent(context, MenuActivity.class);
                    startActivity(tela);
                    finish();
                }else{
                    exibirToast("Dados Invalidos");
                }
            }
        });
    }
    private void exibirToast(String texto){
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        } catch (Exception ex) {

        }
    }
}