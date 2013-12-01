package com.holtaf.virtualclass.model;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by holtaf on 10/13/13.
 */
public class Lesson implements Serializable {
    private final String lessonText;
    private final String title;
    private final List<Question> questionList;

    public Lesson(String title, String text, List<Question> questionList) {
        this.title = title;
        this.lessonText = text;
        this.questionList = new LinkedList<Question>(questionList);
    }

    public String getTitle() {
        return title;
    }

    public String getLessonText() {
        return lessonText;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
