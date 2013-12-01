package com.holtaf.virtualclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.holtaf.virtualclass.R;
import com.holtaf.virtualclass.adapter.LessonListAdapter;
import com.holtaf.virtualclass.model.Course;
import com.holtaf.virtualclass.model.Lesson;
import com.holtaf.virtualclass.util.JSONSerializer;
import com.holtaf.virtualclass.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    private ListView lessonsListView;
    private LessonListAdapter listAdapter;

    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lessonsListView = (ListView) findViewById(R.id.lesson_list);

        JSONObject courseJson = null;
        try {
            courseJson = new JSONObject(Utils.readStringFromStream(getResources().openRawResource(R.raw.lessons)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (courseJson != null) {
            course = JSONSerializer.courseFromJSON(courseJson);
            listAdapter = new LessonListAdapter(this, course);
        }

        lessonsListView.setAdapter(listAdapter);
        lessonsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openLessonActivity(course.getLessonList().get(position));
            }
        });
    }

    private void openLessonActivity(Lesson lesson) {
        Intent intent = new Intent(this, LessonActivity.class);
        intent.putExtra(LessonActivity.EXTRA_IN_LESSON, lesson);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
