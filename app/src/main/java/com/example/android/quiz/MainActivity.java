package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getName(){
        EditText text=(EditText) findViewById(R.id.Input);
        String name=text.getText().toString();
        return name;
    }
    public int calculateMark(){
        int marks=0;

        RadioGroup checker;
        checker=(RadioGroup) findViewById(R.id.radio_group1);

        int choice=checker.getCheckedRadioButtonId();
        if(choice==R.id.Extensible){
            marks+=2;
            count+=1;
        }

         checker=(RadioGroup) findViewById(R.id.radio_group2);

        choice=checker.getCheckedRadioButtonId();
        if(choice==R.id.a){
            marks+=2;
            count+=1;
        }
        checker=(RadioGroup) findViewById(R.id.radio_group3);

        choice=checker.getCheckedRadioButtonId();
        if(choice==R.id.java_vertual_machine){
            marks+=2;
            count+=1;
        }
        checker=(RadioGroup) findViewById(R.id.radio_group4);

        choice=checker.getCheckedRadioButtonId();
        if(choice==R.id.New){
            marks+=2;
            count+=1;
        }
        CheckBox check=(CheckBox) findViewById(R.id.integer);
        CheckBox check1=(CheckBox)findViewById(R.id.string);
        if(check.isChecked() && check1.isChecked()){
            count+=1;
            marks+=2;
        }


        return marks;
    }

    void display(View view){
       int  obtainMarks=calculateMark();
        TextView message=(TextView) findViewById(R.id.score);
       String print="Name :"+getName();
       print+="\nmarks : "+obtainMarks;
       double per=(obtainMarks*100)/10;
       String status=" ";
       if(per<40.0){
           status="Fail";

       }
       else {
           status="Pass";

       }
       print+="\ncorrect answers are : "+ count;
        int temp=5-count;
        print+="\nIncorrect answers are : "+ temp;
       print+="\nStatus :"+status;
        message.setText(print);
        Toast.makeText(this,print,Toast.LENGTH_LONG).show();
    }
}
