package gk1.phansithanh.thigiuakibmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnBMI, btnMonAn, btnBaiThuoc, btnGioiThieu;

    void timDK() {
        btnBMI = findViewById(R.id.btn_bmi);
        btnMonAn = findViewById(R.id.btn_mon_an);
        btnBaiThuoc = findViewById(R.id.btn_bai_thuoc);
        btnGioiThieu = findViewById(R.id.btn_gioi_thieu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timDK();

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBMI = new Intent(MainActivity.this, BMI.class);
                startActivity(iBMI);
            }
        });

        btnMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMonAn = new Intent(MainActivity.this, MonAn.class);
                startActivity(iMonAn);
            }
        });

        btnBaiThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBaiThuoc = new Intent(MainActivity.this, BaiThuoc.class);
                startActivity(iBaiThuoc);
            }
        });

    }
}