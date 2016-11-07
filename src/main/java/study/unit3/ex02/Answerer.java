package study.unit3.ex02;

import java.util.Locale;
import java.util.ResourceBundle;

public class Answerer {
    private ResourceBundle questions;
    private ResourceBundle answers;

    Answerer(String lang) {
        questions = ResourceBundle.getBundle("study.unit3.ex02.questions", new Locale(lang));
        answers = ResourceBundle.getBundle("study.unit3.ex02.answers", new Locale(lang));
    }

    public void showAllQuestions() {
        StringBuilder questionsString = new StringBuilder();
        questionsString.append("\n" + questions.getString("header") + "\n");
        for (int i = 1; i <= 4; i++) questionsString.append(i + ". " + questions.getString("q" + i) + "\n");
        System.out.println(questionsString);
    }

    public void showAnswer(int answerNumber) {
        StringBuilder answersString = new StringBuilder();
        answersString.append(questions.getString("question") + ": " + questions.getString("q" + answerNumber) + "\n");
        answersString.append(answers.getString("answer") + ": " + answers.getString("a" + answerNumber));
        System.out.println(answersString);
    }
}
