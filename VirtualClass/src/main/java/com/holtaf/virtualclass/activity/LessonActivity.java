package com.holtaf.virtualclass.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.holtaf.virtualclass.R;
import com.holtaf.virtualclass.dialog.QuestionDialog;
import com.holtaf.virtualclass.model.Lesson;

/**
 * Created by holtaf on 10/13/13.
 */
public class LessonActivity extends Activity {
    public static final String EXTRA_IN_LESSON = "extra.lesson";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lesson);

        final Lesson lesson = (Lesson) getIntent().getSerializableExtra(EXTRA_IN_LESSON);

        TextView contentView = (TextView) findViewById(R.id.content);
        Button startQuizButton = (Button) findViewById(R.id.btn_start_quiz);

        contentView.setText(lesson.getLessonText());
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionDialog dialog = new QuestionDialog();
                dialog.setQuestionList(lesson.getQuestionList());
                dialog.show(getFragmentManager(), null);
            }
        });

        setTitle(lesson.getTitle());
    }
}
