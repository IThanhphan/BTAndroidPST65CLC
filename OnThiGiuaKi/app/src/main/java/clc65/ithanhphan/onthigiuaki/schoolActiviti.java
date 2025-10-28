package clc65.ithanhphan.onthigiuaki;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class schoolActiviti extends AppCompatActivity {
    infoActiAdapter infoActiA;
    ArrayList<infoActi> listData;
    RecyclerView recyclerViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_activiti);

        listData = getData();
        recyclerViewInfo = findViewById(R.id.recycland);

        RecyclerView.LayoutManager layoutGrid = new LinearLayoutManager(this);
        recyclerViewInfo.setLayoutManager(layoutGrid);

        infoActiA = new infoActiAdapter(this, listData);
        recyclerViewInfo.setAdapter(infoActiA);

    }
    ArrayList<infoActi> getData() {
        ArrayList<infoActi> list = new ArrayList<>();
        list.add(new infoActi("tieu de 1", "20/01/2025", "logo_ntu"));
        list.add(new infoActi("tieu de 2", "21/01/2025", "logo_ntu"));
        list.add(new infoActi("tieu de 3", "22/01/2025", "logo_ntu"));
        return list;
    }

}