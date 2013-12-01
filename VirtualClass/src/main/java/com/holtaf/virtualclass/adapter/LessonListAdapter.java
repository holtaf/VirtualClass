package com.holtaf.virtualclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.holtaf.virtualclass.R;
import com.holtaf.virtualclass.model.Course;

/**
 * Created by holtaf on 10/19/13.
 */
public class LessonListAdapter extends BaseAdapter {
    private Course course;
    private Context context;

    public LessonListAdapter(Context context, Course course) {
        this.course = course;
        this.context = context;
    }

    @Override
    public int getCount() {
        return course.getLessonList().size();
    }

    @Override
    public Object getItem(int position) {
        return course.getLessonList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lesson_list_item, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.lesson_list_item_title)).setText(course.getLessonList().get(position).getTitle());

        return convertView;
    }
}
