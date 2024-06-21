package Com.Quiz.Application;

import java.awt.*;
import javax.swing.*;

// 1. Main Application Frame
public class QuizApplication extends JFrame {
    private QuizController quizController;
    private UserInterface userInterface;

    public QuizApplication() {
        setTitle("Quiz Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Initialize quiz controller and user interface
        quizController = new QuizController();
        userInterface = new UserInterface(quizController);

        // Add user interface to the main frame
        getContentPane().add(userInterface, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizApplication quizApplication = new QuizApplication();
            quizApplication.setVisible(true);
        });
    }
}

