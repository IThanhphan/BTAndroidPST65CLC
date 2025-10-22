package clc65.ithanhphan.viduintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //1. Nha ve Intent
        Intent iNhanDuoc = getIntent();
        //2. Boc ra
        String htNhanDuoc = iNhanDuoc.getStringExtra("ht");
        //3. Xu ly
        //Set len textview
        TextView tv_hienthi = findViewById(R.id.tv_hienthi);
        tv_hienthi.setText(htNhanDuoc);
        //nut Back
        Button buttonBack = findViewById(R.id.btnBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iQuayBack = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(iQuayBack);
            }
        });
    }
}