package br.edu.ifpb.evento.activity;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.edu.ifpb.evento.R;
import br.edu.ifpb.evento.entidade.Pessoa;
import br.edu.ifpb.evento.asynctask.BuscarNomeGetAsyncTask;
import br.edu.ifpb.evento.util.BuscarPessoaCallBack;
import br.edu.ifpb.evento.util.PessoasCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class buscar_nome Activity implements TextWatcher,BuscarPessoaCallBack, AdapterView.OnItemClickListener {

    private EditText nomeBusca;

    List<Pessoa> pessoas;
    PessoasCustomAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nome_busca);

        nomeBusca = (EditText) findViewById(R.id.nomeBuscaText);
        nomeBusca.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.nomeListView);
        pessoas = new ArrayList<Pessoa>();
        adapter = new PessoasCustomAdapter(this, pessoas);

        nomesListView.setAdapter(adapter);

        nomesListView.setOnItemClickListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        Log.i("EditTextListener", "onTextChanged: " + charSequence);
        String nome = charSequence.toString();

        if (nome.length() >= 4) {

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);

            BuscarNomeGetAsyncTask buscarNomeAsyncTask = new BuscarNomeGetAsyncTask(this);
            buscarNomeAsyncTask.execute(pessoa);
        }else{
            this.pessoas.clear();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void backBuscarNome(List<Pessoa> names) {
        this.pessoas.clear();
        this.pessoas.addAll(pessoas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorBuscarNome(String error) {
        pessoas.clear();
        adapter.notifyDataSetChanged();

        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
