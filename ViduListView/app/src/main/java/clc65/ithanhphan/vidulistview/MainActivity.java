package clc65.ithanhphan.vidulistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvNguoiYeuCu;
    ArrayList<String> lstNYC = new ArrayList<>();
    ArrayAdapter<String> nycAdapter;

    void TimDK() {
        lvNguoiYeuCu = findViewById(R.id.lvNYC);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDK();

        //Chuẩn bị nguồn dữ liệu hiển
        //Khai báo

        //Lấy dữ liệu đưa vào lstNYC
        lstNYC = getData();
        //Tạo adapter
        nycAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstNYC);
        lvNguoiYeuCu.setAdapter(nycAdapter);
        lvNguoiYeuCu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Xử lý việc chon Item ở đây
                //Biến position chứa vị trí của Item được chọn
                //Lấy giá trị của phần tử được chọn
                //Cách 1: lấy gián tiếp qua Adapter
                String nycDuocChon = nycAdapter.getItem(position).toString();
                //Cách 2: Lấy trực tiếp từ biến chứa danh sách
                //String nycDuocChon2 = lstNYC.get(position);
                //Làm gì với nó thì tùy bài toán
                String thongBao = "Bạn đã chọn gặp lại NYC: " + nycDuocChon;
                Toast.makeText(MainActivity.this, thongBao, Toast.LENGTH_LONG).show();
            }
        });
    }

    ArrayList<String> getData() {
        //Code đọc dữ liệu và cất vào biến tạm, trước khi return cho
        ArrayList<String> dsTam = new ArrayList<>();
        dsTam.add("Tiểu Vy");
        dsTam.add("Lâm Tâm Như");
        dsTam.add("Britney");
        return dsTam;
    }
}