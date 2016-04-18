package br.edu.ifpb.evento.util;


/**
 * Created by Rafael on 17/04/2016.
 */
import java.util.List;

import br.edu.ifpb.evento.entidade.Pessoa;

public interface BuscarPessoaCallBack {

    void backBuscarNome(List<Pessoa> names);

    void errorbuscar_Nome(String error);
}