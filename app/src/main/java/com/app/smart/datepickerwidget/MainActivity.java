package com.app.smart.datepickerwidget;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    DatePickerDialog datePickerDialog;
    private int year, month, day;
    TextView dateView;
    customToast toastdata;
    Toast toast;
    TextView text,selectedRadioButton;

    Button confirm;

    RadioGroup radioGroup;
    RadioButton firstLevel, secondLevel, thirdLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedRadioButton = findViewById(R.id.showSelection);

        confirm = findViewById(R.id.checkRadioButton);

        radioGroup = findViewById(R.id.radioGroup);

        firstLevel = findViewById(R.id.firstLevel);
        secondLevel = findViewById(R.id.secondLevel);
        thirdLevel = findViewById(R.id.thirdLevel);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_custom_toast,
                (ViewGroup) findViewById(R.id.relativeLayout1));

       text = findViewById(R.id.textView1);

        toast = new Toast(this);
        toast.setView(view);
     //   text.setText("your score is good");
       // toast.show();
        dateView = findViewById(R.id.textView3);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, year, month, day);
        // dp = findViewById(R.id.datePicker);

        showDate(year, month + 1, day);

        show();

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

        toast.show();


        //Toast.makeText(getApplicationContext(), "",
//                Toast.LENGTH_SHORT)
//                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };


    private void showDate(int year1, int month1, int day1) {
        dateView.setText(new StringBuilder().append(day1).append("/")
                .append(month1).append("/").append(year1));
    }

    public void show(){
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId==firstLevel.getId()){
                    selectedRadioButton.setText("first level is selcted");
                    selectedRadioButton.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                if (selectedId==secondLevel.getId()){
                    selectedRadioButton.setText("second level is selcted");
                    selectedRadioButton.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                if (selectedId==thirdLevel.getId()){
                    selectedRadioButton.setText("third level is selcted");
                    selectedRadioButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }


            }
        });

    }
}