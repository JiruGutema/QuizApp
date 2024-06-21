package Com.Quiz.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizController {
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public QuizController() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;

        // Add sample questions
        addQuestion("How many Continents are there?", new ArrayList<>(List.of("10", "9", "7", "5")), 2);
        addQuestion("How many Days are there in a year?", new ArrayList<>(List.of("300", "365", "20", "460")), 1);
        addQuestion("How many countries are there in a Africa?", new ArrayList<>(List.of("58", "54","52","56")), 3);
//        addQuestion("what is 3+3 ?", new ArrayList<>(List.of("0", "9","6","33")), 2);
//        addQuestion("what is the capital of Ethiopia?", new ArrayList<>(List.of("Adama", "Addis Ababa","Jimma","Jigjiga")), 1);
    }

    public void addQuestion(String question, ArrayList<String> options, int correctAnswer) {
        questions.add(new Question(question, options, correctAnswer));
        Collections.shuffle(questions);
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void checkAnswer(int selectedAnswer) {
        if (selectedAnswer == getCurrentQuestion().getCorrectAnswer()) {
            score++;
        }
//        else if (selectedAnswer != getCurrentQuestion().getCorrectAnswer()) {
//            score--;
//        }
        currentQuestionIndex++;
    }

    public int getScore() {
        return score;
    }

    public boolean hasMoreQuestions() {
        return currentQuestionIndex < questions.size();
    }
}