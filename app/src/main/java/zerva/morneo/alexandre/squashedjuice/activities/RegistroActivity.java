package zerva.morneo.alexandre.squashedjuice.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import zerva.morneo.alexandre.squashedjuice.MainActivity;
import zerva.morneo.alexandre.squashedjuice.R;
import zerva.morneo.alexandre.squashedjuice.entidades.Informe;
import zerva.morneo.alexandre.squashedjuice.entidades.Registro;

public class RegistroActivity extends AppCompatActivity {

    EditText etNombre,etApellido,etTelefono,etDireccion;
    Spinner tipoRecogida;
    Informe informe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        relacionGraficaLogica();
        iniciarSpinner();

    }

    private void iniciarSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,R.array.tipoRecogida, android.R.layout.simple_spinner_item);
        tipoRecogida.setAdapter(adapter);

        tipoRecogida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (tipoRecogida.getSelectedItemPosition() == 0 || tipoRecogida.getSelectedItemPosition() == 1){
                    etDireccion.setVisibility(View.GONE);
                }else{
                    etDireccion.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void relacionGraficaLogica() {
        etNombre = findViewById(R.id.nombre_registro);
        etTelefono = findViewById(R.id.telefono_registro);
        etApellido = findViewById(R.id.apellido_registro);
        etDireccion = findViewById(R.id.direccion_registro);
        tipoRecogida = findViewById(R.id.spnRecogida_registro);
    }

    public void continuarZumo(View view) {
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String telefono = etTelefono.getText().toString();
        String direccion = etDireccion.getText().toString();
        boolean recogida = tipoRecogida.getSelectedItemPosition()==2;

        Registro registro = new Registro(nombre,apellido,telefono,direccion,recogida);

        /*
        Antes de pasar al siguiente Activity comprobaremos que los valores introducidos sean correctos y
        que no falta ningun campo obligatorio por rellenar
         */
        if (nombre.isEmpty()||telefono.isEmpty()|| tipoRecogida.getSelectedItemPosition() == 0){
            ErrorDatos();
        }else if (nombre.isEmpty()||telefono.isEmpty()|| (tipoRecogida.getSelectedItemPosition() == 2 && direccion.isEmpty())){
            ErrorDireccion();
        }else {

            if (this.informe == null) {
                this.informe = new Informe();
            }
            this.informe.setRegistros(registro);
            /*
            Enviamos el objeto con la información del activity registro a la siguente activty para su captura
            y ampliación de datos si fuera necesario.
             */
            Intent i = new Intent(RegistroActivity.this, ZumoActivity.class);
            i.putExtra("informe",informe);
            startActivity(i);
        }

    }
    private void ErrorDireccion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setCancelable(false)
                .setMessage("Los campos Nombre, Teléfono, Tipo de Recogida y Dirección son obligatorios")
                .setPositiveButton("Aceptar",null);
        builder.create().show();
    }

    private void ErrorDatos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setCancelable(false)
                .setMessage("Los campos Nombre, Teléfono y Tipo de Recogida son obligatorios")
                .setPositiveButton("Aceptar",null);
        builder.create().show();
    }


    public void volverMain(View view) {
        Intent i = new Intent(RegistroActivity.this, MainActivity.class);
        startActivity(i);
    }
}