package gk1.phansithanh.thigiuakibmi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaiThuoc extends AppCompatActivity {
    BaiThuocAdapter baiThuocAdapter;
    ArrayList<BaiThuocView> listBaiThuoc;
    RecyclerView recyclerViewBaiThuoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_thuoc);

        listBaiThuoc = getData();
        recyclerViewBaiThuoc = findViewById(R.id.recycler_bai_thuoc);

        RecyclerView.LayoutManager layoutGrid = new LinearLayoutManager(this);
        recyclerViewBaiThuoc.setLayoutManager(layoutGrid);

        baiThuocAdapter = new BaiThuocAdapter(this, listBaiThuoc);
        recyclerViewBaiThuoc.setAdapter(baiThuocAdapter);
    }

    ArrayList<BaiThuocView> getData() {
        ArrayList<BaiThuocView> list = new ArrayList<>();
        list.add(new BaiThuocView("baithuoc", "Thuốc nam", "20/01/2025"));
        list.add(new BaiThuocView("baithuoc", "Thuốc bắc", "21/01/2025"));
        list.add(new BaiThuocView("baithuoc", "Thuốc tây", "22/01/2025"));
        return list;
    }
}