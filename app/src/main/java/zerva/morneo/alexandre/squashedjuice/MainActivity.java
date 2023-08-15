package zerva.morneo.alexandre.squashedjuice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import zerva.morneo.alexandre.squashedjuice.activities.RegistroActivity;
import zerva.morneo.alexandre.squashedjuice.activities.ZumoActivity;
import zerva.morneo.alexandre.squashedjuice.option_menu.AboutActivity;
import zerva.morneo.alexandre.squashedjuice.option_menu.HelpActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*
     * Mostramos el menu creado en el main.
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    /*
     * Creamos los acciones que realizarán los items del menú.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about){
            Intent acerca_de = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(acerca_de);
        }else if(id == R.id.help){
            Intent ayuda = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(ayuda);
        }
        return super.onOptionsItemSelected(item);
    }
    /*
     *Creamos el método para cambiar de activity
     */
    public void irRegistro(View view) {
        Intent i = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(i);
    }
}