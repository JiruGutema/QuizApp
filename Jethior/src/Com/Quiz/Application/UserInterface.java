package Com.Quiz.Application;

import javax.swing.*;
import java.awt.*;

// 4. User Interface
class UserInterface extends JPanel {
    private QuizController quizController;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private JButton submitButton;
    private JLabel scoreLabel;

    public UserInterface(QuizController quizController) {
        this.quizController = quizController;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Question label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        questionLabel = new JLabel();
        add(questionLabel, gbc);

        // Option buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        optionButtons = new JRadioButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            buttonGroup.add(optionButtons[i]);
            add(optionButtons[i], gbc);
            gbc.gridy++;
        }

        // Submit button
        gbc.gridx = 0;
        gbc.gridy = 5;
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> handleSubmit());
        add(submitButton, gbc);

        // Score label
        gbc.gridx = 1;
        gbc.gridy = 5;
        scoreLabel = new JLabel();
        add(scoreLabel, gbc);

        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (quizController.hasMoreQuestions()) {
            Question currentQuestion = quizController.getCurrentQuestion();
            questionLabel.setText(currentQuestion.getQuestion());
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(currentQuestion.getOptions().get(i));
            }
            scoreLabel.setText("Score: " + quizController.getScore());
        } else {
            questionLabel.setText("Quiz completed!");
            for (JRadioButton button : optionButtons) {
                button.setVisible(false);
            }
            submitButton.setVisible(false);
            scoreLabel.setText("Final score: " + quizController.getScore());
        }
    }

    private void handleSubmit() {
        int selectedAnswer = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedAnswer = i;
                break;
            }
        }
        if (selectedAnswer != -1) {
            quizController.checkAnswer(selectedAnswer);
            displayNextQuestion();
        }

    }
}
