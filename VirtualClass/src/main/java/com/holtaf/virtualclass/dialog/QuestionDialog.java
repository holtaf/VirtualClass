package com.holtaf.virtualclass.dialog;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.holtaf.virtualclass.R;
import com.holtaf.virtualclass.model.Question;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by holtaf on 10/19/13.
 */
public class QuestionDialog extends DialogFragment implements View.OnClickListener {

    private List<Question> questionList;
    private int currentQuestionRightAnswerIndex;
    private int currentQuestionIndex = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    public void setQuestionList(List<Question> questionList) {
        this.questionList = new LinkedList<Question>(questionList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_dialog, container, false);
    }

    @SuppressLint("NewApi")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        currentQuestionIndex = 0;
        showQuestion(0);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void showQuestion(int questionIndex) {
        if (questionIndex >= questionList.size()) {
            dismiss();
            return;
        }

        View root = getView();

        Question question = questionList.get(questionIndex);

        getDialog().setTitle(question.getTitle());

        TextView questionText = (TextView) root.findViewById(R.id.question);
        questionText.setText(question.getQuestion());

        Button btnAnswer1 = (Button) root.findViewById(R.id.btn_answer1);
        Button btnAnswer2 = (Button) root.findViewById(R.id.btn_answer2);
        Button btnAnswer3 = (Button) root.findViewById(R.id.btn_answer3);
        Button btnAnswer4 = (Button) root.findViewById(R.id.btn_answer4);

        btnAnswer1.setText(question.getAnswers().get(0));
        btnAnswer2.setText(question.getAnswers().get(1));
        btnAnswer3.setText(question.getAnswers().get(2));
        btnAnswer4.setText(question.getAnswers().get(3));

        btnAnswer1.setBackgroundResource(android.R.drawable.btn_default);
        btnAnswer2.setBackgroundResource(android.R.drawable.btn_default);
        btnAnswer3.setBackgroundResource(android.R.drawable.btn_default);
        btnAnswer4.setBackgroundResource(android.R.drawable.btn_default);

        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
        btnAnswer4.setOnClickListener(this);

        currentQuestionRightAnswerIndex = questionList.get(questionIndex).getRightAnswerIndex();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_answer1: {
                Button btn = (Button) getView().findViewById(R.id.btn_answer1);
                if (currentQuestionRightAnswerIndex == 0) {
                    btn.setBackgroundColor(Color.GREEN);
                } else {
                    btn.setBackgroundColor(Color.RED);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showQuestion(++currentQuestionIndex);
                    }
                }, 1000);
                break;
            }

            case R.id.btn_answer2: {
                Button btn = (Button) getView().findViewById(R.id.btn_answer2);
                if (currentQuestionRightAnswerIndex == 1) {
                    btn.setBackgroundColor(Color.GREEN);
                } else {
                    btn.setBackgroundColor(Color.RED);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showQuestion(++currentQuestionIndex);
                    }
                }, 1000);
                break;
            }


            case R.id.btn_answer3: {
                Button btn = (Button) getView().findViewById(R.id.btn_answer3);
                if (currentQuestionRightAnswerIndex == 2) {
                    btn.setBackgroundColor(Color.GREEN);
                } else {
                    btn.setBackgroundColor(Color.RED);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showQuestion(++currentQuestionIndex);
                    }
                }, 1000);
                break;
            }


            case R.id.btn_answer4: {
                Button btn = (Button) getView().findViewById(R.id.btn_answer4);
                if (currentQuestionRightAnswerIndex == 3) {
                    btn.setBackgroundColor(Color.GREEN);
                } else {
                    btn.setBackgroundColor(Color.RED);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showQuestion(++currentQuestionIndex);
                    }
                }, 1000);
                break;
            }

        }
    }
}
