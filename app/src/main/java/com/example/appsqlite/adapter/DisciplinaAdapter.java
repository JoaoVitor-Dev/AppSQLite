package com.example.appsqlite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.appsqlite.R;
import com.example.appsqlite.entities.Disciplina;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;

public class DisciplinaAdapter extends BaseAdapter
{

    private LayoutInflater inflater;
    private ArrayList<Disciplina> disciplinas;

    public DisciplinaAdapter(LayoutInflater inflater, ArrayList<Disciplina> disciplinas)
    {
        this.inflater = inflater;
        this.disciplinas = disciplinas;
    }

    @Override
    public int getCount()
    {
        return disciplinas.size();
    }

    @Override
    public Object getItem(int position)
    {
        return disciplinas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Disciplina disciplina = disciplinas.get(position);

        convertView = inflater.inflate(R.layout.item_list_disciplina, null);

        TextView nome = convertView.findViewById(R.id.textNome);
        TextView aluno = convertView.findViewById(R.id.textNomeAluno);

        nome.setText(disciplina.getNome().toString());
        aluno.setText(disciplina.getAlunoId().getNome().toString());

        return convertView;
    }
}
