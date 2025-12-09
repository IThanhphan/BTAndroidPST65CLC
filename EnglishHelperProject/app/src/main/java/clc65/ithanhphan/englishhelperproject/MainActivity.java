package clc65.ithanhphan.englishhelperproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusBtn = findViewById(R.id.plus_btn);
        TextView numVoca = findViewById(R.id.num_voca);

        ArrayList<Vocabulary> dsTu = getVocabularyData();
        ArrayList<String> dsTenTu = new ArrayList<>();

        for (Vocabulary tu : dsTu) {
            dsTenTu.add(tu.getWord());
        }

        numVoca.setText(dsTu.size() + " từ");

        Intent iflashCard = new Intent(MainActivity.this, FlashCardActivity.class);
        startActivity(iflashCard);

        ListView listView = findViewById(R.id.lst_vocabulary);
        ArrayAdapter<String> adapterTuVung = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dsTenTu);
        listView.setAdapter(adapterTuVung);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vocabulary tu = dsTu.get(position);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(tu.getWord())
                        .setMessage("Ghi chú: " + (tu.getNote().isEmpty() ? "Không có" : tu.getNote()))

                        // Nút sửa
                        .setPositiveButton("Sửa", (dialog, which) -> {
                            showEditDialog(tu, dsTu, dsTenTu, adapterTuVung, numVoca);
                        })

                        // Nút xóa
                        .setNegativeButton("Xóa", (dialog, which) -> {
                            db.delete("VOCABULARY", "ID=?", new String[]{String.valueOf(tu.getVocabularyID())});

                            dsTu.clear();
                            dsTu.addAll(getVocabularyData());

                            dsTenTu.clear();
                            for (Vocabulary x : dsTu) dsTenTu.add(x.getWord());

                            adapterTuVung.notifyDataSetChanged();
                            numVoca.setText(dsTu.size() + " từ");

                            Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                        })

                        // Nút đóng
                        .setNeutralButton("Đóng", null)
                        .show();
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_word, null);

                EditText etWord = dialogView.findViewById(R.id.etWord);
                EditText etNote = dialogView.findViewById(R.id.etNote);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thêm từ vựng")
                        .setView(dialogView)
                        .setPositiveButton("Thêm", (dialog, which) -> {
                            String word = etWord.getText().toString().trim();
                            String note = etNote.getText().toString().trim();

                            if (!word.isEmpty()) {
                                ContentValues row = new ContentValues();
                                row.put("WORD", word);
                                row.put("NOTE", note);

                                db.insert("VOCABULARY", null, row);

                                // Cập nhật lại danh sách
                                dsTu.clear();
                                dsTu.addAll(getVocabularyData());

                                dsTenTu.clear();
                                for (Vocabulary tu : dsTu) {
                                    dsTenTu.add(tu.getWord());
                                }

                                adapterTuVung.notifyDataSetChanged();

                                // Cập nhật số lượng từ
                                numVoca.setText(dsTu.size() + " từ");

                                Toast.makeText(MainActivity.this,
                                        "Đã thêm: " + word, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this,
                                        "Bạn chưa nhập từ vựng", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Hủy", null)
                        .show();
            }
        });
    }

    private void showEditDialog(Vocabulary tu, ArrayList<Vocabulary> dsTu, ArrayList<String> dsTenTu, ArrayAdapter<String> adapter, TextView numVoca) {

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_word, null);
        EditText etWord = dialogView.findViewById(R.id.etWord);
        EditText etNote = dialogView.findViewById(R.id.etNote);

        etWord.setText(tu.getWord());
        etNote.setText(tu.getNote());

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Sửa từ vựng")
                .setView(dialogView)
                .setPositiveButton("Lưu", (dialog, which) -> {
                    String newWord = etWord.getText().toString().trim();
                    String newNote = etNote.getText().toString().trim();

                    if (!newWord.isEmpty()) {
                        ContentValues row = new ContentValues();
                        row.put("WORD", newWord);
                        row.put("NOTE", newNote);

                        db.update("VOCABULARY", row, "ID=?", new String[]{String.valueOf(tu.getVocabularyID())});

                        dsTu.clear();
                        dsTu.addAll(getVocabularyData());

                        dsTenTu.clear();
                        for (Vocabulary x : dsTu) dsTenTu.add(x.getWord());

                        adapter.notifyDataSetChanged();
                        numVoca.setText(dsTu.size() + " từ");

                        Toast.makeText(MainActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }


    ArrayList<Vocabulary> getVocabularyData() {
        db = openOrCreateDatabase("vocabulary.db", MODE_PRIVATE, null);
        String sqlTaoBang = "CREATE TABLE IF NOT EXISTS VOCABULARY (ID INTEGER PRIMARY KEY AUTOINCREMENT, WORD TEXT NOT NULL, NOTE TEXT);";
        db.execSQL(sqlTaoBang);

        String sqlSelectAll = "SELECT * FROM VOCABULARY";
        Cursor resultSet = db.rawQuery(sqlSelectAll, null);
        ArrayList<Vocabulary> dsTuVung = new ArrayList<Vocabulary>();
        if (resultSet.moveToFirst()) {
            do {
                int maTu = resultSet.getInt(0);
                String tenTu = resultSet.getString(1);
                String ghiChu = resultSet.getString(2);

                dsTuVung.add(new Vocabulary(maTu, tenTu, ghiChu));

            } while (resultSet.moveToNext());
        }

        return dsTuVung;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null) db.close();
    }
}