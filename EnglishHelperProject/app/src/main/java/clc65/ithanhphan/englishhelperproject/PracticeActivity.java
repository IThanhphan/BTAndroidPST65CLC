package clc65.ithanhphan.englishhelperproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class PracticeActivity extends AppCompatActivity {
    SQLiteDatabase db;
    TextView questionText, progressText, resultText;
    EditText answerInput;
    Button nextBtn;

    ArrayList<WordItem> questions = new ArrayList<>();
    int currentIndex = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        questionText = findViewById(R.id.question_text);
        answerInput = findViewById(R.id.answer_input);
        progressText = findViewById(R.id.progress_text);
        nextBtn = findViewById(R.id.next_btn);

        loadRandomWords();
        showQuestion();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void loadRandomWords() {
        db = openOrCreateDatabase("vocabulary.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS VOCABULARY (ID INTEGER PRIMARY KEY AUTOINCREMENT, WORD TEXT NOT NULL, NOTE TEXT)");

        Cursor cursor = db.rawQuery("SELECT WORD, NOTE FROM VOCABULARY", null);

        ArrayList<WordItem> allWords = new ArrayList<>();

        while (cursor.moveToNext()) {
            allWords.add(new WordItem(
                    cursor.getString(0),
                    cursor.getString(1)
            ));
        }
        cursor.close();

        Collections.shuffle(allWords);

        int limit = Math.min(10, allWords.size());
        for (int i = 0; i < limit; i++) {
            questions.add(allWords.get(i));
        }
    }

    private void showQuestion() {
        if (currentIndex < questions.size()) {
            WordItem item = questions.get(currentIndex);

            questionText.setText("Nghĩa tiếng Việt: " + item.meaning);
            progressText.setText((currentIndex + 1) + "/" + questions.size());
            answerInput.setText("");
        } else {
            showFinalScore();
        }
    }

    private void checkAnswer() {
        String userAns = answerInput.getText().toString().trim().toLowerCase();
        String correctAns = questions.get(currentIndex).word.toLowerCase();

        if (userAns.equals(correctAns)) {
            score++;
        }

        currentIndex++;
        showQuestion();
    }

    private void showFinalScore() {
        questionText.setText("Hoàn thành!\nĐiểm của bạn: " + score + "/10");
        progressText.setText("");
        answerInput.setVisibility(View.GONE);
        nextBtn.setText("Làm lại");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartPractice();
            }
        });
    }

    private void restartPractice() {
        currentIndex = 0;
        score = 0;
        questions.clear();

        answerInput.setVisibility(View.VISIBLE);
        nextBtn.setText("Tiếp tục");

        loadRandomWords();
        showQuestion();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    class WordItem {
        String word, meaning;
        WordItem(String w, String m) { word = w; meaning = m; }
    }
}
