package com.example.appsqlite.view;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.appsqlite.R;
import com.example.appsqlite.controller.Controle;
import com.example.appsqlite.database.BancoManager;
import com.example.appsqlite.entities.Disciplina;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;

public class CadastroDisciplinaActivity extends AppCompatActivity
{
    private Button btnVoltar, btnSalvar;
    private Spinner spinnerAlunos;
    private EditText edtNome;
    private Controle controle;
    private BancoManager dm;
    private Estudante estudanteSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);
        setup();

        //Intent intent = getIntent();
        //controle = intent.getParcelableExtra("controle");

        btnVoltar.setOnClickListener(v -> startActivity(new Intent(CadastroDisciplinaActivity.this, MainActivity.class)));

        btnSalvar.setOnClickListener(v -> salvarDisciplina());

        listarAlunos();
    }

    private void setup()
    {
        btnVoltar = findViewById(R.id.btnVoltar);
        btnSalvar = findViewById(R.id.btnSalvar);
        edtNome = findViewById(R.id.edtNomeDisciplina);
        spinnerAlunos = findViewById(R.id.spinner_alunos);

        dm = new BancoManager(this);
        SQLiteDatabase db = dm.open();
        controle = new Controle(db);
    }

    private void listarAlunos()
    {
        ArrayList<Estudante> alunosLista = controle.consultarAlunos();

        ArrayAdapter<Estudante> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, alunosLista);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAlunos.setAdapter(adapter);
        spinnerAlunos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                estudanteSelecionado = (Estudante) parent.getItemAtPosition(position);

                Toast.makeText(CadastroDisciplinaActivity.this, estudanteSelecionado.getNome().toString(),  Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void salvarDisciplina()
    {
        String nome = edtNome.getText().toString();

        Disciplina disciplina = new Disciplina(nome, estudanteSelecionado);
      controle.adicionarDisciplina(disciplina);
    }
}
