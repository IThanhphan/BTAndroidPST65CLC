package clc65.ithanhphan.cacpheptoansohoc;

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
    EditText n1, n2;
    Button add, sub, mul, div;
    TextView rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        mul = findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        rs = findViewById(R.id.rs);
    }

    public void Cong(View v) {
        String strSo1 = n1.getText().toString();
        String strSo2 = n2.getText().toString();
        String strKetQua = rs.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);
        int tong = soA + soB;
        String strTong = "Kết quả: " + String.valueOf(tong);

        rs.setText(strTong);
    }

    public void Tru(View v) {
        String strSo1 = n1.getText().toString();
        String strSo2 = n2.getText().toString();
        String strKetQua = rs.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);
        int tong = soA - soB;
        String strTong = "Kết quả: " + String.valueOf(tong);

        rs.setText(strTong);
    }

    public void Nhan(View v) {
        String strSo1 = n1.getText().toString();
        String strSo2 = n2.getText().toString();
        String strKetQua = rs.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);
        int tong = soA * soB;
        String strTong = "Kết quả: " + String.valueOf(tong);

        rs.setText(strTong);
    }

    public void Chia(View v) {
        String strSo1 = n1.getText().toString();
        String strSo2 = n2.getText().toString();
        String strKetQua = rs.getText().toString();

        float soA = Float.parseFloat(strSo1);
        float soB = Float.parseFloat(strSo2);
        if (soB == 0) {
            String strTong = "Không thể chia cho 0";
            rs.setText(strTong);
        } else {
            float tong = soA / soB;
            String strTong = "Kết quả: " + String.valueOf(tong);
            rs.setText(strTong);
        }
    }
}