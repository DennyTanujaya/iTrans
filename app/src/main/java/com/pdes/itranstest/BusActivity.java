package com.pdes.itranstest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker;

import java.text.SimpleDateFormat;


public class BusActivity extends AppCompatActivity {
    Spinner typeBusLabel;
    String typeBus, startDate, endDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_bus);
        Spinner listArmadaSpinner = (Spinner) findViewById(R.id.listArmada);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        typeBus = extras.getString("typeBus");
        startDate = extras.getString("startDate");
        endDate = extras.getString("endDate");

        String[] BigBus = getResources().getStringArray(R.array.Big_Bus_armada_arrays);
        String[] MediumBus = getResources().getStringArray(R.array.Medium_Bus_armada_arrays);
        String[] MiniVan = getResources().getStringArray(R.array.Mini_Van_armada_arrays);
        String[] Car = getResources().getStringArray(R.array.Car_armada_arrays);

        if(typeBus.equals("Big Bus")) {
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, BigBus);
            listArmadaSpinner.setAdapter(dataAdapter);
        } else if (typeBus.equals("Medium Bus")){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MediumBus);
            listArmadaSpinner.setAdapter(dataAdapter);
        } else if (typeBus.equals("Mini Van")){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MiniVan);
            listArmadaSpinner.setAdapter(dataAdapter);
        } else if (typeBus.equals("Car")){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Car);
            listArmadaSpinner.setAdapter(dataAdapter);
        }



    }

    public void onNextIndex(View view) {

        typeBusLabel = (Spinner) findViewById(R.id.listArmada);
        String typeBusString = String.valueOf(typeBusLabel.getSelectedItem());


        Intent moveToPickingCalendarActivity = new Intent(BusActivity.this, PickingCalendarActivity.class);
        moveToPickingCalendarActivity.putExtra("typeBus", typeBusString);
        moveToPickingCalendarActivity.putExtra("startDate", startDate);
        moveToPickingCalendarActivity.putExtra("endDate", endDate);
        startActivity(moveToPickingCalendarActivity);

    }
}
