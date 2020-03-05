package com.pdes.itranstest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_bus);

    }

    public void onNextIndex(View view) {
        typeBusLabel = (Spinner) findViewById(R.id.listArmada);
        String typeBus = String.valueOf(typeBusLabel.getSelectedItem());


        Intent moveToIndex = new Intent(BusActivity.this, IndexActivity.class);
        moveToIndex.putExtra("typeBus", typeBus);
        startActivity(moveToIndex);

    }
}
