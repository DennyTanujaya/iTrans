package com.pdes.itranstest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {
    DatePicker simpleDatePicker;
    Button nextCalendar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // initiate the date picker and a button
        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
        nextCalendar = (Button) findViewById(R.id.nextCalendar);
        simpleDatePicker.setSpinnersShown(false); // set false value for the spinner shown function
        // perform click event on submit button
        nextCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                int day = simpleDatePicker.getDayOfMonth(); // get the selected day of the month
                int month = simpleDatePicker.getMonth() + 1; // get the selected month
                int year = simpleDatePicker.getYear(); // get the selected year
            }
        });





    }
}
