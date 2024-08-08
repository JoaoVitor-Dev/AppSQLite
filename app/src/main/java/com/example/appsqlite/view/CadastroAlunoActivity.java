package com.example.appsqlite.view;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.appsqlite.R;
import com.example.appsqlite.controller.Controle;
import com.example.appsqlite.database.BancoManager;
import com.example.appsqlite.entities.Estudante;

import java.util.List;

public class CadastroAlunoActivity extends AppCompatActivity
{

    private BancoManager dm;
    private Controle controle;
    private Button btnVoltar, btnSalvar;
    private EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_aluno);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();

        btnVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity((new Intent(CadastroAlunoActivity.this, MainActivity.class)));
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salvarAluno();
            }
        });
    }

    public void salvarAluno()
    {
        String nome = edtNome.getText().toString();

        Estudante aluno = new Estudante(nome);

        List<Long> id = controle.adicionarAluno(aluno);

        Toast.makeText(this, "Aluno cadastrado", Toast.LENGTH_SHORT).show();

        irParaListagem();
    }

    private void setup()
    {
        btnVoltar = findViewById(R.id.btnVoltar);
        btnSalvar = findViewById(R.id.btnSalvar);
        edtNome = findViewById(R.id.edtNome);

        dm = new BancoManager(this);
        SQLiteDatabase db = dm.open();
        controle = new Controle(db);
    }

    private void irParaListagem()
    {
        startActivity(new Intent(CadastroAlunoActivity.this, AlunoActivity.class));
    }
}