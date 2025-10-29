package gk1.phansithanh.thigiuakibmi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MonAn extends AppCompatActivity {
    ListView listViewMonAn;
    ArrayList<String> listMonAn = new ArrayList<>();
    ArrayAdapter<String> monAnAdapter;

    void timDK() {
        listViewMonAn = findViewById(R.id.lst_mon_an);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an);

        timDK();

        listMonAn = getData();
        monAnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listMonAn);
        listViewMonAn.setAdapter(monAnAdapter);
    }

    ArrayList<String> getData() {
        ArrayList<String> lm = new ArrayList<>();
        lm.add("Gà xào xả ớt");
        lm.add("Tôm chiên xù");
        lm.add("Mì xào hải sản");
        lm.add("Cơm chiên");
        lm.add("Salad");
        return lm;
    }
}