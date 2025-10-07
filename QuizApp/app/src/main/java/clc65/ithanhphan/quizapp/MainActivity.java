package clc65.ithanhphan.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtQuestion;
    Button btn1, btn2, btn3, btn4;

    QuestionGenerator generator = new QuestionGenerator();
    QuestionGenerator.Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuestion = findViewById(R.id.result);
        btn1 = findViewById(R.id.da1);
        btn2 = findViewById(R.id.da2);
        btn3 = findViewById(R.id.da3);
        btn4 = findViewById(R.id.da4);

        loadNewQuestion();

        View.OnClickListener answerClick = v -> {
            Button clicked = (Button) v;
            int chosen = Integer.parseInt(clicked.getText().toString());
            if (chosen == currentQuestion.correctAnswer) {
                Toast.makeText(this, "🎉 Chính xác!", Toast.LENGTH_SHORT).show();
                loadNewQuestion(); // 👉 Sinh câu mới
            } else {
                Toast.makeText(this, "❌ Sai rồi!", Toast.LENGTH_SHORT).show();
            }
        };

        btn1.setOnClickListener(answerClick);
        btn2.setOnClickListener(answerClick);
        btn3.setOnClickListener(answerClick);
        btn4.setOnClickListener(answerClick);

    }

    private void loadNewQuestion() {
        currentQuestion = generator.generateQuestion();

        txtQuestion.setText(currentQuestion.questionText);
        btn1.setText(String.valueOf(currentQuestion.options.get(0)));
        btn2.setText(String.valueOf(currentQuestion.options.get(1)));
        btn3.setText(String.valueOf(currentQuestion.options.get(2)));
        btn4.setText(String.valueOf(currentQuestion.options.get(3)));
    }
}