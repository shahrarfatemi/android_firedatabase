package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.util.NumberUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameEditText,ageEditText;
    Button saveButton,loadButton,updateButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("People");

        nameEditText = findViewById(R.id.nameId);
        ageEditText =findViewById(R.id.ageId);
        saveButton = findViewById(R.id.saveButtonId);
        loadButton = findViewById(R.id.loadButtonId);
        updateButton = findViewById(R.id.updateButtonId);
        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.saveButtonId){
            saveData();
        }
        else if(v.getId() == R.id.loadButtonId){
            Toast.makeText(getApplicationContext(), " haaaaaa" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.updateButtonId){
            updateDate();
        }
    }

    public void saveData(){
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();

        if(name.isEmpty()){
            nameEditText.setError("Enter a valid name");
            nameEditText.requestFocus();
            return;
        }
        if(age.isEmpty()){
            ageEditText.setError("Enter a valid age");
            ageEditText.requestFocus();
            return;
        }

        if(!isNumeric(age)){
            Toast.makeText(getApplicationContext(),"invalid age input",Toast.LENGTH_SHORT).show();
            ageEditText.setError("Enter a valid age");
            ageEditText.requestFocus();
            return;
        }

        double _age = Double.parseDouble(age);
        Student student = new Student(name,_age);

        String key = databaseReference.push().getKey();

        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),key,Toast.LENGTH_SHORT).show();

    }

    public boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    public void updateDate(){

    }
}
