package clc65.ithanhphan.onthigiuaki;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class list_subject extends AppCompatActivity {
    ListView listViewSubject;
    ArrayList<String> listSubject = new ArrayList<>();
    ArrayAdapter<String> subjectAdapter;

    void timDK() {
        listViewSubject = findViewById(R.id.lv_sb);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subject);
        timDK();

        listSubject = getData();
        subjectAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSubject);
        listViewSubject.setAdapter(subjectAdapter);


    }
    ArrayList<String> getData() {
        ArrayList<String> lm = new ArrayList<>();
        lm.add("Tin học đại cương");
        lm.add("Lập trình java");
        lm.add("Phát triển ứng dụng web");
        lm.add("Khai phá dữ liệu lớn");
        lm.add("Kinh tế chính trị Mác-Lê nin");
        return lm;
    }
}