package com.example.appsqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.appsqlite.database.BancoContract;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO
{
   private SQLiteDatabase db;

   public EstudanteDAO(SQLiteDatabase db)
   {
       this.db = db;
   }

   public long adicionarAluno(Estudante aluno)
   {
       ContentValues values = new ContentValues();

       values.put(BancoContract.AlunoTable.COLUMN_NAME, aluno.getNome());
       long alunoId = db.insert(BancoContract.AlunoTable.TABLE_NAME, null, values);

       return alunoId;
   }

    public List<Estudante> obterTodosAlunos()
    {
        List<Estudante> listaAlunos = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + BancoContract.AlunoTable.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext())
        {
            Estudante aluno = new Estudante();

            aluno.setId(cursor.getLong(cursor.getColumnIndexOrThrow(BancoContract.AlunoTable._ID)));
            aluno.setNome(cursor.getString(cursor.getColumnIndexOrThrow(BancoContract.AlunoTable.COLUMN_NAME)));

            listaAlunos.add(aluno);
        }

        cursor.close();
        return listaAlunos;
    }
}
