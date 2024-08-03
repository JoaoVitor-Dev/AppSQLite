package com.example.appsqlite.entities;

public class Disciplina
{
    private long id;
    private String nome;
    private Estudante alunoId;

    public Disciplina() {
    }

    public Disciplina(String nome, Estudante alunoId) {
        this.nome = nome;
        this.alunoId = alunoId;
    }

    public Disciplina(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Disciplina(long id, String nome, Estudante alunoId) {
        this.id = id;
        this.nome = nome;
        this.alunoId = alunoId;
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

    public Estudante getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Estudante alunoId) {
        this.alunoId = alunoId;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", alunoId=" + alunoId +
                '}';
    }
}
