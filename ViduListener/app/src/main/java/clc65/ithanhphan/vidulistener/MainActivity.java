package clc65.ithanhphan.vidulistener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button bSayHi, bSayHello;

    void TimDK() {
        bSayHi = findViewById(R.id.btnSayHi);
        bSayHello = findViewById(R.id.btnSayHello);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDK();
        bSayHi.setOnClickListener(ngheSayHi);
        bSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();
            }
        });
    }
    View.OnClickListener ngheSayHi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_LONG).show();
        }
    };
}