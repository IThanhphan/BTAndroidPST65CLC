package clc65.ithanhphan.tong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edSo1, edSo2;
    TextView tvKetQua;
    Button btnTinhToan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSo1 = findViewById(R.id.fn);
        edSo2 = findViewById(R.id.sn);
        tvKetQua = findViewById(R.id.rs);
        btnTinhToan = findViewById(R.id.add_btn);
    }

    public void HamTinhTong(View v) {
        String strSo1 = edSo1.getText().toString();
        String strSo2 = edSo2.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);
        int tong = soA + soB;
        String strTong = String.valueOf(tong);

        tvKetQua.setText(strTong);
    }
}