package zerva.morneo.alexandre.squashedjuice.option_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zerva.morneo.alexandre.squashedjuice.MainActivity;
import zerva.morneo.alexandre.squashedjuice.R;

public class HelpActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        btn = findViewById(R.id.btn_volver_help);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HelpActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}