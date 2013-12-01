package com.holtaf.virtualclass.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by holtaf on 10/19/13.
 */
public class Course implements Serializable {
    private final List<Lesson> lessonList;
    private final String title;

    public Course(String title, List<Lesson> lessonList) {
        this.title = title;
        this.lessonList = new LinkedList<Lesson>(lessonList);
    }

    /**
     * @return the copy of list of Lessons
     * */
    public List<Lesson> getLessonList() {
        return new LinkedList<Lesson>(lessonList);
    }

    public String getTitle() {
        return title;
    }
}
