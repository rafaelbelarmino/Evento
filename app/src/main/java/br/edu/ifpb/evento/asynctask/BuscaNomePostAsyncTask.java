package br.edu.ifpb.evento.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.ifpb.evento.entidade.Pessoa;
import br.edu.ifpb.evento.util.BuscarPessoaCallBack;
import br.edu.ifpb.evento.util.HttpService;
import br.edu.ifpb.evento.util.Response;


/**
 * Created by Rafael on 17/04/2016.
 */
public class BuscarNomePostAsyncTask extends AsyncTask<Pessoa, Void, Response> {

    private BuscarPessoaCallBack buscarNomeCallBack;

    public BuscarNomePostAsyncTask(BuscarPessoaCallBack buscarNomeCallBack) {

        this.buscarNomeCallBack = buscarNomeCallBack;
    }

    @Override
    protected Response doInBackground(Pessoa... pessoas) {

        Response response = null;

        Pessoa pessoa = pessoas[0];
        Log.i("EditTextListener", "doInBackground (JSON): " + pessoa);

        try {

            Gson gson = new Gson();
            response = HttpService.sendJSONPostResquest("get-byname", gson.toJson(pessoa));

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "Código HTTP: " + codeHttp
                + " Conteúdo: " + response.getContentValue());

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            buscarNomeCallBack.errorBuscarNome(response.getContentValue());

        } else {

            Gson gson = new Gson();
            List<Pessoa> pessoas = gson.fromJson(response.getContentValue(),
                    new TypeToken<ArrayList<Pessoa>>(){}.getType());

            buscarNomeCallBack.backBuscarNome(pessoas);
        }
    }
}