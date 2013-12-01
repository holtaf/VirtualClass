package com.holtaf.virtualclass.util;

import com.holtaf.virtualclass.model.Course;
import com.holtaf.virtualclass.model.Lesson;
import com.holtaf.virtualclass.model.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by holtaf on 10/19/13.
 */
public class JSONSerializer {
    private static final String TITLE = "title";
    private static final String LESSONS = "lessons";
    private static final String CONTENT = "content";
    private static final String QUESTIONS = "questions";
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String ANSWERS = "answers";

    private JSONSerializer() {
    }

    public static Question questionFromJSON(JSONObject json) {
        try {
            String title = json.getString(TITLE);
            String question = json.getString(QUESTION);
            int rightAnswer = json.getInt(ANSWER);
            JSONArray answerArray = json.getJSONArray(ANSWERS);

            List<String> answerList = new ArrayList<String>();

            for (int i = 0, len = answerArray.length(); i < len; ++i) {
                answerList.add(answerArray.getString(i));
            }

            return new Question(title, question, answerList, rightAnswer);
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static Lesson lessonFromJSON(JSONObject json) {
        try {
            String title = json.getString(TITLE);
            String content = json.getString(CONTENT);
            JSONArray questionArray = json.getJSONArray(QUESTIONS);

            List<Question> questionList = new ArrayList<Question>();

            for (int i = 0, len = questionArray.length(); i < len; ++i) {
                questionList.add(questionFromJSON(questionArray.getJSONObject(i)));
            }

            return new Lesson(title, content, questionList);
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static Course courseFromJSON(JSONObject json) {
        try {
            String title = json.getString(TITLE);

            List<Lesson> lessons = new LinkedList<Lesson>();

            JSONArray lessonsArray = json.getJSONArray(LESSONS);

            for (int i = 0, len = lessonsArray.length(); i < len; ++i) {
                lessons.add(lessonFromJSON(lessonsArray.getJSONObject(i)));
            }

            return new Course(title, lessons);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
