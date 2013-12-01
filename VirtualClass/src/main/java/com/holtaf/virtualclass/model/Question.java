package com.holtaf.virtualclass.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by holtaf on 10/13/13.
 */
public class Question implements Serializable {
    private final String title;
    private final String question;
    private final List<String> answers;
    private final int rightAnswerIndex;

    public Question(String title, String question, List<String> answers, int rightAnswerIndex) {
        this.title = title;
        this.question = question;
        this.answers = new ArrayList<String>(answers);
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public String getTitle() {
        return title;
    }
}
