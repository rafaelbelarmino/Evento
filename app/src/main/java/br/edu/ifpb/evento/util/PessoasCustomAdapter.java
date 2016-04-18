package br.edu.ifpb.evento.util;

/**
 * Created by Rafael on 17/04/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.edu.ifpb.evento.R;
import br.edu.ifpb.evento.entidade.Pessoa;

import java.util.List;


public class PessoasCustomAdapter extends BaseAdapter {

    Context context;

    List<Pessoa> pessoas;

    public PessoasCustomAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)  context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.id_item, null);

            holder = new ViewHolder();
            holder.txtQrCode = (TextView) convertView.findViewById(R.id.qrCodeItemView);
            holder.txtFullName = (TextView) convertView.findViewById(R.id.nomeViewItem);
            holder.txtId = (TextView) convertView.findViewById(R.id.idItemView);
            ;

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoaItem = (Pessoa) getItem(position);

        holder.txtFullName.setText(pessoaItem.getNome());
        holder.txtQrCode.setText("QR CODE: "+pessoaItem.getQrCode());
        holder.txtId.setText("Identificador numérico: "+ pessoaItem.getId());


        return convertView;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pessoas.indexOf(getItem(position));
    }

    private class ViewHolder {

        TextView txtFullName;
        TextView txtQrCode;
        TextView txtId;

    }
}