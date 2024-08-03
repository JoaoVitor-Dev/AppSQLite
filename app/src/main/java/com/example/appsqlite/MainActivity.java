package com.example.appsqlite;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private Button buttonInserirAlunos, buttonListarAlunos, buttonInserirDisciplinas, buttonListarDisciplinas;
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

        setup();

    }

    private void setup(){
        buttonInserirAlunos = findViewById(R.id.btnInserirAlunos);
        buttonInserirDisciplinas = findViewById(R.id.btnInserirDisciplina);
        buttonListarAlunos = findViewById(R.id.btnListarAlunos);
        buttonListarDisciplinas = findViewById(R.id.btnListarDisciplina);
        textViewResultAlunos = findViewById(R.id.textViewResultadoAlunos);
        textViewResultDisciplinas = findViewById(R.id.textViewResultadoDisciplinas);
    }
}