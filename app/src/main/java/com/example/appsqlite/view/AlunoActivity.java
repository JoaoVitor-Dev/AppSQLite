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
import com.example.appsqlite.controller.Controle;
import com.example.appsqlite.database.BancoManager;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;

public class AlunoActivity extends AppCompatActivity
{

    private Button btnSair;
    private ArrayList<Estudante> alunos;
    private AlunoAdapter adapter;
    private BancoManager dm;
    private Controle controle;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aluno);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();

        btnSair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AlunoActivity.this, MainActivity.class));
            }
        });

        carregarLista();
    }

    private void setup()
    {
        dm = new BancoManager(this);
        SQLiteDatabase db = dm.open();
        controle = new Controle(db);

        btnSair = findViewById(R.id.btnVoltar);
        listView = findViewById(R.id.listView);
    }

    public void carregarLista()
    {
        adapter = new AlunoAdapter(this.getLayoutInflater(), controle.consultarAlunos());
        listView.setAdapter(adapter);
    }


}