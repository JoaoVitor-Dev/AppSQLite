package com.example.appsqlite.view;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.appsqlite.R;
import com.example.appsqlite.adapter.AlunoAdapter;
import com.example.appsqlite.adapter.DisciplinaAdapter;
import com.example.appsqlite.controller.Controle;
import com.example.appsqlite.database.BancoManager;
import com.example.appsqlite.entities.Disciplina;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;

public class DisciplinasActivity extends AppCompatActivity
{
    private DisciplinaAdapter adapter;
    private ListView listView;
    private ArrayList<Disciplina> disciplinas;
    private BancoManager dm;
    private Controle controle;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_disciplinas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();
        carregarLista();

        btnVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(DisciplinasActivity.this, MainActivity.class));
            }
        });
    }

    private void setup()
    {
        listView = findViewById(R.id.listViewDisciplinas);
        btnVoltar = findViewById(R.id.btnVoltar);

        dm = new BancoManager(this);
        SQLiteDatabase db = dm.open();
        controle = new Controle(db);
    }

    private void carregarLista()
    {
        adapter = new DisciplinaAdapter(this.getLayoutInflater(), (ArrayList<Disciplina>) controle.consultarDisciplinasPorAluno());
        listView.setAdapter(adapter);
    }
}