package com.example.appsqlite.controller;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.example.appsqlite.dao.DisciplinaDAO;
import com.example.appsqlite.dao.EstudanteDAO;
import com.example.appsqlite.entities.Disciplina;
import com.example.appsqlite.entities.Estudante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Controle implements Serializable
{
    private EstudanteDAO alunoDao;
    private DisciplinaDAO disciplinaDAO;
    private SQLiteDatabase db;

    public Controle(SQLiteDatabase db)
    {
        this.db = db;
        alunoDao = new EstudanteDAO(db);
        disciplinaDAO = new DisciplinaDAO(db);
    }

    public List<Long> adicionarAluno(Estudante aluno)
    {
        List<Long> ids = new ArrayList<>();

        long alunoId = alunoDao.adicionarAluno(aluno);

        ids.add(alunoId);

        return ids;
    }

    public ArrayList<Estudante> consultarAlunos()
    {
        List<Estudante> alunos = alunoDao.obterTodosAlunos();
        return (ArrayList<Estudante>) alunos;
    }

    public List<Long> adicionarDisciplina(Disciplina disciplina)
    {

        List<Long> ids = new ArrayList<>();
//        List<Estudante> alunos = alunoDao.obterTodosAlunos();


        long disciplinaId = disciplinaDAO.inserirDisciplina(disciplina);
        ids.add(disciplinaId);

//        disciplina = new Disciplina("BIO101", alunos.get(0));
//        disciplinaId = disciplinaDAO.inserirDisciplina(disciplina);
//        ids.add(disciplinaId);

        return ids;
    }

    public List<Disciplina> consultarDisciplinasPorAluno()
    {
        List<Estudante> alunos = alunoDao.obterTodosAlunos();
        List<Disciplina> disciplinas = disciplinaDAO.listarDisciplinas(alunos.get(0));
        return disciplinas;
    }


    public String alterarAluno(Estudante aluno)
    {
        return aluno.toString();//
    }
}
