package clc65.ithanhphan.unitconvert;

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
    EditText usd, vnd;
    Button convertBtn;
    final double USD_VND = 26362;

    void find() {
        usd = findViewById(R.id.USD);
        vnd = findViewById(R.id.VND);
        convertBtn = findViewById(R.id.convert_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find();
        convertBtn.setOnClickListener(convertCurrency);
    }

    View.OnClickListener convertCurrency = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String usdStr = usd.getText().toString().trim();
            String vndStr = vnd.getText().toString().trim();
            double usdDouble, vndDouble;
            String result;

            if (usdStr.isEmpty()) {
                usdDouble = 0;
            } else {
                usdDouble = Double.parseDouble(usdStr);
            }
            if (vndStr.isEmpty()) {
                vndDouble = 0;
            } else {
                vndDouble = Double.parseDouble(vndStr);
            }

            if (usdDouble == 0 && vndDouble != 0) {
                usdDouble = vndDouble * 1/USD_VND;
                usdDouble = Math.round(usdDouble * 100.0) / 100.0;
                result = String.valueOf(usdDouble);
                usd.setText(result);
            } else {
                vndDouble = usdDouble * USD_VND;
                vndDouble = Math.round(vndDouble * 100.0) / 100.0;
                result = String.valueOf(vndDouble);
                vnd.setText(result);
            }
        }
    };
}