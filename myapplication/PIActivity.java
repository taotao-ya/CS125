package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PIActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup mRG1;
    private  RadioGroup mRG2;
    private  RadioGroup mRG3;
    public EditText mAge;
    public String age;
//    private EditText mGender;
    public  String gender;
    public EditText mWeight;
    public String weight;
    public EditText mHeight;
    public String height;
    public  String sleepTime;
    public  String food;
    public EditText mSystolicPressure;

    public String systolicPressure;
    public EditText mDiastolicPressure;

    public String diastolicPressure;
    public Button mBtn;
    public String subAge, subGender, subWeight, subHeight, subSleep, subFood;

    public double score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piactivity);

        mRG1 = findViewById(R.id.rg_1);
        mRG2 = findViewById(R.id.rg_2);
        mRG3 = findViewById(R.id.rg_3);
        mAge = findViewById((R.id.et_1));
        mWeight = findViewById((R.id.et_2));
        mHeight = findViewById((R.id.et_3));
        mSystolicPressure = findViewById(R.id.systolic);
        mDiastolicPressure = findViewById(R.id.diastolic);
        mBtn = findViewById(R.id.pIAbtn1);


        mRG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton mRB1 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB1.getText(), Toast.LENGTH_SHORT).show();
                gender = mRB1.getText().toString();
            }
        });

        mRG2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton mRB2 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB2.getText(), Toast.LENGTH_SHORT).show();
                sleepTime = mRB2.getText().toString();
            }
        });

        mRG3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton mRB3 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB3.getText(), Toast.LENGTH_SHORT).show();
                food = mRB3.getText().toString();
            }
        });

        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        age = mAge.getText().toString();
        weight = mWeight.getText().toString();
        height = mHeight.getText().toString();
        systolicPressure = mSystolicPressure.getText().toString();
        diastolicPressure = mDiastolicPressure.getText().toString();

        int weightNum = 0;
        int heightNum = 0;
        int sysNum = 0;
        int diaNum = 0;
        weightNum = Integer.parseInt(weight);
        heightNum = Integer.parseInt(height);
        sysNum = Integer.parseInt(systolicPressure);
        diaNum = Integer.parseInt(diastolicPressure);
        if((float)weightNum/(heightNum/100)*(heightNum/100) < 18.5 || (float)weightNum/(heightNum/100)*(heightNum/100) > 24){
        } else{
            score += 20;
        }
        if(90 < sysNum && sysNum < 140)
            score += 20;
        if(60 < diaNum && diaNum < 90)
            score += 20;

        subSleep = sleepTime.substring(0, 1);
        if(subSleep.equals("7"))
            score += 20;

        subFood = food.substring(0, 1);
        if(subFood.equals("O") || subFood.equals("N"))
            score += 20;

        Intent intent = null;
        intent = new Intent(PIActivity.this, CSActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("age", age);
        bundle.putString("gender", gender);
        bundle.putString("weight", weight);
        bundle.putString("height", height);
        bundle.putString("sleepTime", sleepTime);
        bundle.putString("food", food);
        bundle.putDouble("score", score);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}