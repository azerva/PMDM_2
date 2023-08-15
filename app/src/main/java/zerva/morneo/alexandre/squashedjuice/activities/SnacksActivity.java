package zerva.morneo.alexandre.squashedjuice.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

import zerva.morneo.alexandre.squashedjuice.R;
import zerva.morneo.alexandre.squashedjuice.adapter.SnacksAdapter;
import zerva.morneo.alexandre.squashedjuice.entidades.Informe;
import zerva.morneo.alexandre.squashedjuice.entidades.Snacks;

public class SnacksActivity extends AppCompatActivity {

    Informe informe;

    CheckBox cb_celiaco,cb_lactosa;

    SnacksAdapter adapter;
    ArrayList<Snacks> snacksList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        cb_celiaco = findViewById(R.id.checkbox_celiaco);
        cb_lactosa= findViewById(R.id.checkbox_lactosa);

        informe = (Informe) getIntent().getExtras().getSerializable("informe");

        startRecycler();
    }

    private void startRecycler() {
        recyclerView = findViewById(R.id.rv_snakcs);

        int orientacion = getResources().getConfiguration().orientation;
        int columnas;
        if (orientacion == Configuration.ORIENTATION_PORTRAIT){
            columnas = 1;
        }else{
            columnas = 3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this,columnas));

        addSnacks();

        adapter = new SnacksAdapter(snacksList);
        recyclerView.setAdapter(adapter);

        adapter.setOnitemClickListener(position -> {
            adapter.notifyItemChanged(position);
        });
    }

    private void addSnacks() {
        snacksList = new ArrayList<>();

        snacksList.add(new Snacks(R.drawable.papas_fritas,"Patatas fritas",1.25F,0,false,false));
        snacksList.add(new Snacks(R.drawable.pistachos,"Pistachos",1.75F,0,false,false));
        snacksList.add(new Snacks(R.drawable.frutos_secos,"Frutos secos",1.50F,0,false,false));
    }

    public void resetCantidadesSnacks(View view) {
        for (Snacks s: snacksList){
            if (s.getCantidadSnack()>0){
                s.setCantidadSnack(0);
            }
            startRecycler();
        }
    }

    public void volverZumos(View view) {
        Intent i = new Intent(SnacksActivity.this,ZumoActivity.class);
        i.putExtra("informe",informe);
        startActivity(i);

    }

    public void continuarInforme(View view) {

        if (!selecionArticulo()){
            alertNoSeleccionZumo();
        }else{
            this.informe.setSnacks(snacksList);
            Intent i = new Intent(SnacksActivity.this, InformeActivity.class);
            i.putExtra("informe", informe);
            startActivity(i);
        }

    }

    private boolean selecionArticulo() {
        boolean articuloSeleccionado = true;
        for (Snacks s: snacksList){
            if (s.getCantidadSnack() > 0){
                articuloSeleccionado = true;
            }
        }
        return articuloSeleccionado;
    }
    private void alertNoSeleccionZumo() {
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccion Articulos")
                //.setCancelable(false)
                .setMessage("No ha seleccionado ningún artículo de la lista. ¿Está seguro que desea continuar?")
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        continuarSinZumo();
                    }
                })
                .setNegativeButton("CANCELAR", null);
        builder.create().show();
    }

    private void continuarSinZumo() {
        Intent i = new Intent(SnacksActivity.this,InformeActivity.class);
        i.putExtra("informe",informe);
        startActivity(i);
    }

}