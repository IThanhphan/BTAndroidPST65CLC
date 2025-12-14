package clc65.ithanhphan.englishhelperproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HelperActivity extends AppCompatActivity {

    Button translateBtn, practiceBtn, practiceBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        translateBtn = findViewById(R.id.translate_btn);
        practiceBtn = findViewById(R.id.practice_btn);
        practiceBtn2 = findViewById(R.id.practice_btn2);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelperActivity.this, TranslateActivity.class));
            }
        });

        practiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelperActivity.this, PracticeActivity.class));
            }
        });

        practiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelperActivity.this, PracticeActivity2.class));
            }
        });
    }
}
