package clc65.ithanhphan.englishhelperproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class PracticeActivity2 extends AppCompatActivity {

    SQLiteDatabase db;
    TextView questionText, progressText;
    Button btnA, btnB, btnC, btnD, nextBtn;

    ArrayList<WordItem> questions = new ArrayList<>();
    ArrayList<String> choices = new ArrayList<>();

    int currentIndex = 0;
    int score = 0;
    String correctAnswer = "";
    String selectedAnswer = "";
    boolean isAnswered = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice2);

        questionText = findViewById(R.id.question_text);
        progressText = findViewById(R.id.progress_text);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        nextBtn = findViewById(R.id.next_btn);

        loadRandomWords();
        showQuestion();

        View.OnClickListener answerClick = v -> {
            if (isAnswered) return; // đã trả lời thì không cho bấm nữa

            Button clickedBtn = (Button) v;
            selectedAnswer = clickedBtn.getText().toString();
            isAnswered = true;

            if (selectedAnswer.equalsIgnoreCase(correctAnswer)) {
                clickedBtn.setBackgroundResource(R.drawable.card_correct);
                score++;
            } else {
                clickedBtn.setBackgroundResource(R.drawable.card_wrong);
                highlightCorrectAnswer();
            }
        };


        btnA.setOnClickListener(answerClick);
        btnB.setOnClickListener(answerClick);
        btnC.setOnClickListener(answerClick);
        btnD.setOnClickListener(answerClick);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void highlightCorrectAnswer() {
        if (btnA.getText().toString().equalsIgnoreCase(correctAnswer)) {
            btnA.setBackgroundResource(R.drawable.card_correct);
        }
        if (btnB.getText().toString().equalsIgnoreCase(correctAnswer)) {
            btnB.setBackgroundResource(R.drawable.card_correct);
        }
        if (btnC.getText().toString().equalsIgnoreCase(correctAnswer)) {
            btnC.setBackgroundResource(R.drawable.card_correct);
        }
        if (btnD.getText().toString().equalsIgnoreCase(correctAnswer)) {
            btnD.setBackgroundResource(R.drawable.card_correct);
        }
    }


    private void loadRandomWords() {
        db = openOrCreateDatabase("vocabulary.db", MODE_PRIVATE, null);

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

            correctAnswer = item.word;
            selectedAnswer = "";
            isAnswered = false;

            createChoices(item.word);
            resetButtons();
        } else {
            showFinalScore();
        }
    }


    private void createChoices(String correctWord) {
        choices.clear();
        choices.add(correctWord);

        for (WordItem w : questions) {
            if (!w.word.equals(correctWord) && choices.size() < 4) {
                choices.add(w.word);
            }
        }

        Collections.shuffle(choices);

        btnA.setText(choices.get(0));
        btnB.setText(choices.get(1));
        btnC.setText(choices.get(2));
        btnD.setText(choices.get(3));

        resetButtons();
    }

    private void checkAnswer() {
        if (!isAnswered) return;

        currentIndex++;
        showQuestion();
    }


    private void showFinalScore() {
        questionText.setText("Hoàn thành!\nĐiểm của bạn: " + score + "/10");
        progressText.setText("");

        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnD.setVisibility(View.GONE);

        nextBtn.setText("Làm lại");
        nextBtn.setOnClickListener(v -> restartPractice());
    }

    private void restartPractice() {
        currentIndex = 0;
        score = 0;
        questions.clear();

        btnA.setVisibility(View.VISIBLE);
        btnB.setVisibility(View.VISIBLE);
        btnC.setVisibility(View.VISIBLE);
        btnD.setVisibility(View.VISIBLE);

        nextBtn.setText("Tiếp tục");

        loadRandomWords();
        showQuestion();

        nextBtn.setOnClickListener(v -> checkAnswer());
    }

    private void resetButtons() {
        btnA.setBackgroundResource(R.drawable.card_input);
        btnB.setBackgroundResource(R.drawable.card_input);
        btnC.setBackgroundResource(R.drawable.card_input);
        btnD.setBackgroundResource(R.drawable.card_input);
    }

    class WordItem {
        String word, meaning;
        WordItem(String w, String m) {
            word = w;
            meaning = m;
        }
    }
}
