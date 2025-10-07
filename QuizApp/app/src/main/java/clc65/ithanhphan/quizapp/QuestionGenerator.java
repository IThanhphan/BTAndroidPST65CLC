package clc65.ithanhphan.quizapp;

import java.util.*;

public class QuestionGenerator {
    private Random random = new Random();

    public Question generateQuestion() {
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        char[] ops = {'+', '-', '*'};
        char op = ops[random.nextInt(ops.length)];

        int correctAnswer;
        switch (op) {
            case '+': correctAnswer = a + b; break;
            case '-': correctAnswer = a - b; break;
            case '*': correctAnswer = a * b; break;
            default: correctAnswer = a + b;
        }

        // Sinh các đáp án
        Set<Integer> options = new HashSet<>();
        options.add(correctAnswer);
        while (options.size() < 4) {
            int fake = correctAnswer + random.nextInt(11) - 5;
            if (fake != correctAnswer && fake >= 0) options.add(fake);
        }

        List<Integer> shuffled = new ArrayList<>(options);
        Collections.shuffle(shuffled);

        return new Question(a + " " + op + " " + b, correctAnswer, shuffled);
    }

    public static class Question {
        public String questionText;
        public int correctAnswer;
        public List<Integer> options;

        public Question(String q, int ans, List<Integer> opts) {
            questionText = q;
            correctAnswer = ans;
            options = opts;
        }
    }
}

