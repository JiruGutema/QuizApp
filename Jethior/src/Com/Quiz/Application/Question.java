package Com.Quiz.Application;

import java.util.ArrayList;

// 1. Question Class
public class Question {
    private String question;
    private ArrayList<String> options;
    private int correctAnswer;

    public Question(String question, ArrayList<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

