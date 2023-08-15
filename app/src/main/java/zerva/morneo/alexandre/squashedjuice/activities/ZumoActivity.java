package zerva.morneo.alexandre.squashedjuice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import zerva.morneo.alexandre.squashedjuice.R;
import zerva.morneo.alexandre.squashedjuice.adapter.ZumoAdapter;
import zerva.morneo.alexandre.squashedjuice.entidades.Informe;
import zerva.morneo.alexandre.squashedjuice.entidades.Registro;
import zerva.morneo.alexandre.squashedjuice.entidades.Zumo;

public class ZumoActivity extends AppCompatActivity {

    Informe informe;

    RecyclerView recyclerView;
    ZumoAdapter adapter;
    ArrayList<Zumo>zumosList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zumo);

        informe = (Informe) getIntent().getExtras().getSerializable("informe");

        startRecycler();

    }

    private void startRecycler() {

        recyclerView = findViewById(R.id.rv_zumos);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        addZumos();

        adapter = new ZumoAdapter(zumosList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            adapter.notifyItemChanged(position);
        });
    }

    private void addZumos() {
         /*
        Llenamos el ArrayList con los datos del producto
         */

        zumosList = new ArrayList<>();

        zumosList.add(new Zumo(R.drawable.zumo_naranaja,"Naranja", 2.25F,0));
        zumosList.add(new Zumo(R.drawable.zumo_melocoton,"Melocotón", 2.25F,0));
        zumosList.add(new Zumo(R.drawable.zumo_fresa,"Fresa", 2.75F,0));
        zumosList.add(new Zumo(R.drawable.zumo_pinia,"Piña", 2.50F,0));
        zumosList.add(new Zumo(R.drawable.zumo_limon,"Limón", 2.25F,0));
        zumosList.add(new Zumo(R.drawable.zumo_pera,"Pera", 2.25F,0));
    }


    public void resetCantidadesZumos(View view) {
        for (Zumo z : zumosList){
            if (z.getCantidadZumo() > 0){
                z.setCantidadZumo(0);
            }
            startRecycler();
        }
    }

    public void volverRegistro(View view) {
        Intent i = new Intent(ZumoActivity.this, Registro.class);
        i.putExtra("informe",informe);
        startActivity(i);
    }

    public void continuarSnacks(View view) {
        /*
        Antes de cambiar de activity vamos a verificar que se hayan seleccionado objetos de la lista,
        en caso contrario generaremos un mensaje de alerta.

        Si he usuario a seleccionado algún articulo empaquetamos el los objetos seleccionados y lo mandamos
        al siguiente activity
         */
/*
        int cantidadSeleccionada = this.zumosList.size();
        for (Zumo z: zumosList){
            if (z.getCantidadZumo()!=0){
                cantidadSeleccionada--;
                if (cantidadSeleccionada==0){
                    Toast.makeText(this, "Seleccione Articulos", Toast.LENGTH_SHORT).show();

                    Snackbar snackbar = Snackbar.make(findViewById(R.id.layout_zumo),"No ha seleccionado ningún articulo." +
                            "¿Desea continuar de todas formas?",Snackbar.LENGTH_LONG);
                    snackbar.setAction("Sí", new continuarSinSeleccion());
                    snackbar.show();
                }
            }else{
                informe.setZumos(zumosList);
                Intent i = new Intent(ZumoActivity.this, InformeActivity.class);
                i.putExtra("informe",informe);
                startActivity(i);
            }
        }*/

        /**
         * No sé porqué siempre me salta el mensaje, no encuetro el fallo.
         */
        if (seleccionZumo()){
            informe.setZumos(zumosList);
            Intent i = new Intent(ZumoActivity.this,SnacksActivity.class);
            i.putExtra("informe",informe);
            startActivity(i);

        }else{
            Toast.makeText(this, "Seleccione Articulos", Toast.LENGTH_SHORT).show();

            Snackbar snackbar = Snackbar.make(findViewById(R.id.layout_zumo),"No ha seleccionado ningún articulo." +
                    "¿Desea continuar de todas formas?",Snackbar.LENGTH_LONG);
            snackbar.setAction("Sí", new continuarSinSeleccion());
            snackbar.show();
        }
        /*
        informe.setZumos(zumosList);
        Intent i = new Intent(ZumoActivity.this, SnacksActivity.class);
        i.putExtra("informe",informe);
        startActivity(i);*/

    }
    //Esta comprobación tampoco me va bien
    private boolean seleccionZumo() {
        /*
        Comprobamos si hay algún articulo seleccionado
         */
        boolean seleccion = false;
        for (Zumo z :zumosList){
            if (z.getCantidadZumo() > 0){
                seleccion = true;
            }
        }
        return seleccion;
    }


    private class continuarSinSeleccion implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            informe.setZumos(zumosList);
            Intent i = new Intent(ZumoActivity.this, Informe.class);
            i.putExtra("informe",informe);
            startActivity(i);
        }
    }
}