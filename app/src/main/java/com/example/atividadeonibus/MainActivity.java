package com.example.atividadeonibus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editMarca;
    EditText editModelo;
    EditText editOrigemDestino;
    EditText editTipo;
    EditText editAssentosTotais;
    EditText editAssentosOcupados;
    ListView listaView;

    List<Busao> listaBusao;
    BusaoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//  captura de dados
        editMarca = findViewById(R.id.textMarca);
        editModelo = findViewById(R.id.textModelo);
        editOrigemDestino = findViewById(R.id.textOrigemDestino);
        editTipo = findViewById(R.id.textTipo);
        editAssentosTotais = findViewById(R.id.textAssentosTotais);
        editAssentosOcupados = findViewById(R.id.textAssentosOcupados);

        listaView = findViewById(R.id.lista);

        listaBusao = new ArrayList<Busao>();
    }

    public void enviarDados(View view) {
        String marca = editMarca.getText().toString();
        String modelo = editModelo.getText().toString();
        String origem = editOrigemDestino.getText().toString();
        String tipo = editTipo.getText().toString();
        String assentosTotais = editAssentosTotais.getText().toString();
        String assentosOcupados = editAssentosOcupados.getText().toString();

        if (Integer.parseInt(assentosTotais) < Integer.parseInt(assentosOcupados)) {
            String info = "O numero de assentos excede o numero total";
            Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
        } else {
            editMarca.setText("");
            editModelo.setText("");
            editOrigemDestino.setText("");
            editTipo.setText("");
            editAssentosTotais.setText("");
            editAssentosOcupados.setText("");
            Busao onibus = new Busao(marca, modelo, origem, tipo, assentosTotais, assentosOcupados);
            listaBusao.add(onibus);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        listaBusao.add(new Busao("volvo","VOLARE W9 ON","curitiba/bahia","leito","30","29"));
        listaBusao.add(new Busao("volvo","VOLARE W8","curitiba/bahia","leito","30","30"));
        listaBusao.add(new Busao("volvo","NEOBUS THUNDER","bahia/curitiba","comum","30","15"));
        preencherOnibusList();
    }

    private void preencherOnibusList() {
        int layoutId = R.layout.busao_list_item;
        adapter = new BusaoAdapter(this, layoutId, listaBusao);
        listaView.setAdapter(adapter);
    }
}