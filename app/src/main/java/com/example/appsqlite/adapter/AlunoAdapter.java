package com.example.appsqlite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.appsqlite.R;
import com.example.appsqlite.entities.Estudante;

import java.util.ArrayList;

public class AlunoAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    private ArrayList<Estudante> alunos;

    public AlunoAdapter(LayoutInflater inflater, ArrayList<Estudante> alunos)
    {
        this.inflater = inflater;
        this.alunos = alunos;
    }

    @Override
    public int getCount()
    {
        return alunos.size();
    }

    @Override
    public Object getItem(int position)
    {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Estudante aluno = alunos.get(position);
       convertView = inflater.inflate(R.layout.listagem_alunos, null);

       TextView name = convertView.findViewById(R.id.name);
       name.setText(aluno.getNome());

       return convertView;
    }
}
