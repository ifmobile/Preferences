package com.example.professor.preferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtAno;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtAno = findViewById(R.id.edtAno);

        prefs = getSharedPreferences("config", MODE_PRIVATE);

        String nome = prefs.getString("nome", null);
        if (nome != null){
            edtNome.setText(nome);
        }
        int ano = prefs.getInt("ano",-1);
        if(ano != -1){
            edtAno.setText(String.valueOf(ano));
        }
    }

    public void salvar(View view) {
        String nome = edtNome.getText().toString();
        int ano = Integer.parseInt(edtAno.getText().toString());

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nome", nome);
        editor.putInt("ano", ano);
        editor.apply();

        Toast.makeText(this, "Dados gravados com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
