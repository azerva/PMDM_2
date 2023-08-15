package zerva.morneo.alexandre.squashedjuice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import zerva.morneo.alexandre.squashedjuice.MainActivity;
import zerva.morneo.alexandre.squashedjuice.R;
import zerva.morneo.alexandre.squashedjuice.entidades.Informe;
import zerva.morneo.alexandre.squashedjuice.entidades.Registro;
import zerva.morneo.alexandre.squashedjuice.entidades.Snacks;
import zerva.morneo.alexandre.squashedjuice.entidades.Zumo;

public class InformeActivity extends AppCompatActivity {

    Informe informe;
    TextView fechaHora,tipoRecogida,nombre,apellido,telefono,direccion,resumenPedido,
            celiaco,lactosa,tvtotal;
    LinearLayout llRecargo, layoutCeliaco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);

        this.informe = (Informe) getIntent().getSerializableExtra("informe");

        resumenPedido = findViewById(R.id.tv_resumen_articulos_informe);
        resumenPedido.setText(informe.toString());

        datosCliente();
        exitoPedido();
        precioTotal();
    }



    private void exitoPedido() {
        Toast.makeText(this,"Pedido realizado con éxito", Toast.LENGTH_LONG).show();
    }

    private void datosCliente() {

        String sdtFecha = new SimpleDateFormat("dd/MM/yyyy -- HH:mm").format(Calendar.getInstance().getTime());
        fechaHora = findViewById(R.id.tv_fechaHora);
        tipoRecogida = findViewById(R.id.tv_tipoRecogida_informe);
        nombre = findViewById(R.id.tv_nombre_informe);
        apellido = findViewById(R.id.tv_apellido_informe);
        telefono = findViewById(R.id.tv_telefono_informe);
        direccion = findViewById(R.id.tv_direccion_informe);
        llRecargo = findViewById(R.id.linear_recargo);

        Registro registro = this.informe.getRegistros();
        String recogida = "";
        if (registro.isDomicilio()){
            recogida = "Domicilio";
        }else{
            recogida = "Establecimiento";
            llRecargo.setVisibility(View.GONE);
            direccion.setVisibility(View.GONE);
        }

        if (registro.getApellidoCliente().isEmpty()){
            apellido.setVisibility(View.GONE);
        }
        /*
        Introducimos los valores en sus respectivas cajas
         */
        fechaHora.setText("Fecha y hora pedido: "+sdtFecha);
        tipoRecogida.setText("Tipo de recogida: "+recogida);
        nombre.setText("Nombre: "+registro.getNombreCliente());
        apellido.setText("Apellido: "+registro.getApellidoCliente());
        telefono.setText("Teléfono: "+ registro.getTelefonoCliente());
        direccion.setText("Dirección entrega: "+registro.getDireccion());

    }

    public void precioTotal(){
        tvtotal = findViewById(R.id.total_informe);
        tvtotal.setText(String.format("%.2f",sumaTotal()*1.07));

    }


    private float sumaTotal(){

        float total=0;
        for (Zumo z : this.informe.getZumos()){
            if(z.getCantidadZumo()>0){
                total += z.getCantidadZumo()*z.getPrecioZumo();
            }
        }
        for (Snacks s : this.informe.getSnacks()){
            if(s.getCantidadSnack()>0){
                total += s.getCantidadSnack()*s.getPrecioSnack();
            }
        }

        if (this.informe.getRegistros().isDomicilio()){
            total += 2.5;
        }

        return total;

    }


    public void volverMain(View view) {
        Intent i = new Intent(InformeActivity.this, MainActivity.class);
        startActivity(i);
    }
}