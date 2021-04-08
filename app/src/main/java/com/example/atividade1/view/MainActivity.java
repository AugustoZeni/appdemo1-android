package com.example.atividade1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.atividade1.R;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtSenha;
    Button btnLogar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogar = findViewById(R.id.btnLogar);

        context = MainActivity.this;

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    String usuario = txtUsuario.getText().toString();
                    String senha = txtSenha.getText().toString();

                    if(usuario.equals("augusto") && senha.equals("123")){

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("usuario", txtUsuario.getText().toString());
                        editor.putString("chavePix", "03591159000");
                        if(editor.commit()){
                            Intent tela = new Intent(context, MenuActivity.class);
                            startActivity(tela);
                            finish();
                        }else{
                            exibirToast("Ops, algo de errado aconteceu...");
                        }
                    }else{
                        exibirToast("Dados Invalidos");
                    }
                }catch (Exception ex){
                    exibirToast(ex.getMessage());
                }
            }
        });

        String nome_usuario = sharedPreferences.getString("usuario", "");
        if(!nome_usuario.equals("")){
            Intent tela = new Intent(context, MenuActivity.class);
            startActivity(tela);
        }
    }
    private void exibirToast(String texto){
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        } catch (Exception ex) {

        }
    }
}