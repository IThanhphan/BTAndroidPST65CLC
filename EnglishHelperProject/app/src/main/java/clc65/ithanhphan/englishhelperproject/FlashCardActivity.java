package clc65.ithanhphan.englishhelperproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class FlashCardActivity extends AppCompatActivity {
    SQLiteDatabase db;
    FlashCardAdapter adapter;
    ArrayList<Vocabulary> vocabList = new ArrayList<>();
    RecyclerView recyclerViewFlashCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vocabList = getVocabularyData();
        recyclerViewFlashCard = findViewById(R.id.recycler_flash_card);

        RecyclerView.LayoutManager layoutGrid = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFlashCard.setLayoutManager(layoutGrid);

        adapter = new FlashCardAdapter(this, vocabList);
        recyclerViewFlashCard.setAdapter(adapter);
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

        Collections.shuffle(dsTuVung);

        return dsTuVung;
    }
}