package gk1.phansithanh.thigiuakibmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {
    EditText inputCanNang, inputChieuCao;
    Button btnBMI;
    TextView ketQua;

    void timDK() {
        inputCanNang = findViewById(R.id.input_can_nang);
        inputChieuCao = findViewById(R.id.input_chieu_cao);
        btnBMI = findViewById(R.id.btn_tinh_bmi);
        ketQua = findViewById(R.id.ket_qua_bmi);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        timDK();
        btnBMI.setOnClickListener(v -> {
            try {
                double canNang = Double.parseDouble(inputCanNang.getText().toString());
                double chieuCao = Double.parseDouble(inputChieuCao.getText().toString());

                if (chieuCao > 3) {
                    chieuCao = chieuCao / 100.0;
                }

                double bmi = canNang / (chieuCao * chieuCao);

                String danhGia;
                if (bmi < 18.5) {
                    danhGia = "Gầy";
                } else if (bmi < 23) {
                    danhGia = "Bình thường";
                } else if (bmi < 25) {
                    danhGia = "Thừa cân";
                } else if (bmi < 30) {
                    danhGia = "Béo phì độ I";
                } else {
                    danhGia = "Béo phì độ II";
                }

                // Hiển thị kết quả
                String kq = String.format("BMI: %.2f\nPhân loại: %s", bmi, danhGia);
                ketQua.setText(kq);

            } catch (Exception e) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ và đúng định dạng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}