package br.edu.ifpb.evento.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import br.edu.ifpb.evento.MainActivity;
import br.edu.ifpb.evento.R;


public class busca_qrcode extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_qrcode);

        TextView conteudo = (TextView) findViewById(R.id.seuNomeText);
        Intent intent = getIntent();
        conteudo.setText(( (String) intent.getSerializableExtra("<---conteudo Lido--->")));

        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(busca_qrcode.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}