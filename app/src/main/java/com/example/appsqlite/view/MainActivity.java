package com.example.appsqlite.view;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.appsqlite.R;
import com.example.appsqlite.controller.Controle;
import com.example.appsqlite.database.BancoManager;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private BancoManager dm;
    private Controle controle;

    private Button buttonInserirAlunos, buttonListarAlunos, buttonInserirDisciplinas;
    private TextView textViewResultAlunos, textViewResultDisciplinas;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup(); //seta os componentes nos atributos

        dm = new BancoManager(this);
        SQLiteDatabase db = dm.open();
        controle = new Controle(db);

    }

    private void setup()
    {
        buttonInserirAlunos = findViewById(R.id.btnInserirAlunos);
        buttonInserirDisciplinas = findViewById(R.id.btnInserirDisciplina);
        buttonListarAlunos = findViewById(R.id.btnListarAlunos);
    }

    public void clicar(View v)
    {
        if (v.getId() == R.id.btnInserirAlunos)
        {
            adicionarAluno();
        }
        if (v.getId() == R.id.btnListarAlunos)
        {
            consultarAlunos();
        }
        if(v.getId() == R.id.btnInserirDisciplina)
        {
            adicionarDisciplina();
        }
    }

    private void adicionarAluno()
    {
        startActivity((new Intent(MainActivity.this, CadastroAlunoActivity.class)));
    }

    private void consultarAlunos()
    {
        startActivity((new Intent(MainActivity.this, AlunoActivity.class)));
    }

    private void adicionarDisciplina()
    {
        startActivity((new Intent(MainActivity.this, CadastroDisciplinaActivity.class)));
    }

    private void consultarDisciplinasPorAluno()
    {
        String retorno = controle.consultarDisciplinasPorAluno();
        textViewResultDisciplinas.setText(retorno);
    }
}