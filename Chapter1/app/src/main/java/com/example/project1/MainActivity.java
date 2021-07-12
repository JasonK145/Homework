package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton rb_Male, rb_Female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button_change);
        final TextView tv = findViewById(R.id.tv_End);
        final EditText EDT = findViewById(R.id.edit_text);
        rg = (RadioGroup) findViewById(R.id.rg_sex);
        rb_Male = (RadioButton) findViewById(R.id.rb_Male);
        rb_Female = (RadioButton) findViewById(R.id.rb_FeMale);
        rg.setOnCheckedChangeListener(new MyRadioButtonListener());
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv.setText("已報名");
                Log.i("button", "onCreate: finish_change");
                String num = EDT.getText().toString();
                if(TextUtils.isEmpty(num)){
                    tv.setText("報名失敗");
                    Log.i("button", "onCreate: username wasn't typed");
                }
                else  Log.i("button", "onCreate: username is" + num);
            }
        });


    }
    class MyRadioButtonListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_FeMale:
                    Log.i("button", "当前用户选择"+rb_Female.getText().toString());
                    break;
                case R.id.rb_Male:
                    Log.i("button", "当前用户选择"+rb_Male.getText().toString());
                    break;
            }
        }
    }



}


