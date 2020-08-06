package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;
    public CustomAdapter(Activity context, List<Student> studentList) {
        super(context, R.layout.sample,studentList);
        this.context = context;
        this.studentList = studentList;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample,null,true);

        TextView nameText = view.findViewById(R.id.nameTextViewId);
        TextView ageText = view.findViewById(R.id.ageTextViewId);

        Student student = studentList.get(position);

        nameText.setText(student.getName());
        ageText.setText(((Double)student.getAge()).toString());

        return view;
    }
}
