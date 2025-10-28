package clc65.ithanhphan.onthigiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_avr = findViewById(R.id.btn_avr);
        Button btn_lm = findViewById(R.id.btn_lm);
        Button btn_atv = findViewById(R.id.btn_atv);
        Button btn_ac = findViewById(R.id.btn_ac);

        btn_avr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ibtn_avr = new Intent(MainActivity.this, averageScore.class);
                startActivity(ibtn_avr);
            }
        });

        btn_lm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ibtn_lm = new Intent(MainActivity.this, list_subject.class);
                startActivity(ibtn_lm);
            }
        });

        btn_atv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ibtn_atv = new Intent(MainActivity.this, schoolActiviti.class);
                startActivity(ibtn_atv);
            }
        });
    }
}