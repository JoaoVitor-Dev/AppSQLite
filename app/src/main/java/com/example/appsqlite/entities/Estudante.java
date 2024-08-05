package com.example.appsqlite.entities;

import java.util.List;

public class Estudante
{
    private long id;
    private String nome;
    private List<Disciplina> disciplinas;

    public Estudante(){}

    public Estudante(String nome)
    {
        this.nome = nome;
    }

    public Estudante(long id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
