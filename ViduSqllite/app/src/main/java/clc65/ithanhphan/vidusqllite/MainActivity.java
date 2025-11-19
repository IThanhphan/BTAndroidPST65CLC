package clc65.ithanhphan.vidusqllite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> dsTenSach = getBookName();

        ListView listView = findViewById(R.id.lvTenSach);
        ArrayAdapter<String> adapterTenSach = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dsTenSach);
        listView.setAdapter(adapterTenSach);

        Button bThem = findViewById(R.id.btnThemSach);

        bThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edTenSach = findViewById(R.id.edtTemSach);
                String tenSach = edTenSach.getText().toString();

                EditText edGia = findViewById(R.id.edtGiaBan);
                float giaBan = Float.parseFloat(edGia.getText().toString());

                ContentValues row = new ContentValues();
                row.put("BookName", tenSach);
                row.put("Price", giaBan);

                db.insert("BOOKS", null, row);
                dsTenSach.add(tenSach);
                adapterTenSach.notifyDataSetChanged();
            }
        });
    }

    ArrayList<BOOKS> getBookData() {
        db = openOrCreateDatabase("books.db", MODE_PRIVATE, null);

//        String sqlXoaBang = "DROP TABLE IF EXISTS BOOKS";
//        String sqlTaoBang = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text)";
//
//        db.execSQL(sqlXoaBang);
//        db.execSQL(sqlTaoBang);
//
//        String sqlThem1 = "INSERT INTO BOOKS VALUES(1, 'Java', 100, 9.99, 'sách về java')";
//        String sqlThem2 = "INSERT INTO BOOKS VALUES(2, 'Android', 320, 19.00, 'Android cơ bản')";
//
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);

        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll, null);
        ArrayList<BOOKS> dsSach = new ArrayList<BOOKS>();
        resultSet.moveToFirst();
        while (true) {
            int maSach = resultSet.getInt(0);
            String tenSach = resultSet.getString(1);
            int soTrang = resultSet.getInt(2);
            float giaBan = resultSet.getFloat(3);
            String moTa = resultSet.getString(4);

            BOOKS book = new BOOKS(maSach, tenSach, soTrang, giaBan, moTa);

            dsSach.add(book);

            if (resultSet.moveToNext() == false) {
                break;
            }
        }

        db.close();
        return dsSach;
    }

    ArrayList<String> getBookName() {
        db = openOrCreateDatabase("books.db", MODE_PRIVATE, null);

        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll, null);
        ArrayList<String> dsTenSach = new ArrayList<String>();
        ArrayList<BOOKS> dsSach = new ArrayList<BOOKS>();
        resultSet.moveToFirst();
        while (true) {
            int maSach = resultSet.getInt(0);
            String tenSach = resultSet.getString(1);
            int soTrang = resultSet.getInt(2);
            float giaBan = resultSet.getFloat(3);
            String moTa = resultSet.getString(4);

            BOOKS book = new BOOKS(maSach, tenSach, soTrang, giaBan, moTa);

            dsTenSach.add(tenSach);
            dsSach.add(book);

            if (resultSet.moveToNext() == false) {
                break;
            }
        }

        db.close();
        return dsTenSach;
    }

}