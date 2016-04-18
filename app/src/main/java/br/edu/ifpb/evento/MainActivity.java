package br.edu.ifpb.evento;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import br.edu.ifpb.evento.R;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.nomeBuscaButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,nomeBusca.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.qrCodeBuscaButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
                scanIntegrator.initiateScan();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult
                (requestCode, resultCode, intent);

        if (scanningResult != null) {
            String conteudo = scanningResult.getContents();

            intent = new Intent(this, qrCodeBusca.class);
            intent.putExtra("Conteudo Lido", conteudo);
            this.startActivity(intent);
            this.finish();

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "A busca não teve exito", Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}