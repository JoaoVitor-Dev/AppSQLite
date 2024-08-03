package com.example.appsqlite.dao;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.appsqlite.database.BancoContract;
import com.example.appsqlite.entities.Disciplina;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO
{
    private SQLiteDatabase db;

    public DisciplinaDAO(SQLiteDatabase db)
    {
        this.db = db;
    }

    public long inserirDisciplina(Disciplina disciplina)
    {
        ContentValues values = new ContentValues();
        values.put(BancoContract.DisciplinaTable.COLUMN_NAME, disciplina.getNome());
        values.put(BancoContract.DisciplinaTable.COLUMN_ALUNO_ID, disciplina.getAlunoId().getId());
        long disciplinaID = db.insert(BancoContract.DisciplinaTable.TABLE_NAME, null, values);

        return disciplinaID;
    }

    public List<Disciplina> listarDisciplinas(Estudante estudante)
    {
        List<Disciplina> disciplinas = new ArrayList<>();
        String selection = BancoContract.DisciplinaTable.COLUMN_ALUNO_ID + " = ?";
        String[] selectionArgs = {String.valueOf(estudante.getId())};

        Cursor cursor = db.query(
                BancoContract.DisciplinaTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,null, null);

        while (cursor.moveToNext())
        {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(BancoContract.DisciplinaTable._ID));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow(BancoContract.DisciplinaTable.COLUMN_NAME));
            Disciplina disciplina = new Disciplina(id, nome,estudante);
            disciplinas.add(disciplina);
        }
        cursor.close();
        return disciplinas;
    }
}
