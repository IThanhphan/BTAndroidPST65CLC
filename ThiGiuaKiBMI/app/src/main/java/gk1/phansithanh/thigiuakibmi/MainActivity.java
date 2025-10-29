package gk1.phansithanh.thigiuakibmi;

import android.os.Bundle;
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


    }
}