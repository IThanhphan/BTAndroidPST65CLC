package clc65.ithanhphan.viduintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nutChuyen2 = findViewById(R.id.btnChuyenSang2);
        nutChuyen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code chuyen man hinh
                //1. Tao intent
                Intent iChuyen2 = new Intent(MainActivity.this, SecondActivity.class);
                //Lay du lieu
                //2 Goi du lieu vao iChuyen2
                // 2.1 Lay du lieu
                EditText edHoTen = findViewById(R.id.edHoTen);
                String data = edHoTen.getText().toString();
                //2.2 Goi vao iChuyen2, dung putExtra(key, value)
                iChuyen2.putExtra("ht", data);
                iChuyen2.putExtra("copyright", "MCT");
                //3 Kich hoat man hinh 2
                startActivity(iChuyen2);

            }
        });
    }
}