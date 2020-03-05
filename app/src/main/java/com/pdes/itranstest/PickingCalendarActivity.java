package com.pdes.itranstest;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.TextView;

public class PickingCalendarActivity extends AppCompatActivity{
    EditText namaTamu, tujuanTamu, standbyTamu, keteranganTamu, beginTimeTamu, endTimeTamu;
    Spinner listCustomersBox;
    CheckBox kePul, internal, fullday;

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picking_calendar);
        TextView thedate = (TextView) findViewById(R.id.date);
        TextView thearmada = (TextView) findViewById(R.id.typeBusLabel);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String date = extras.getString("date");
        String armada = extras.getString("armada");
        thedate.setText(date);
        thearmada.setText(armada);

    }

    public void onBooking(View view) {

        Intent intent = getIntent();
        Bundle extrass = intent.getExtras();
        String dateInput = extrass.getString("date");
        String armadaInput = extrass.getString("armada");

        namaTamu = (EditText)findViewById(R.id.tamuTxt);
        tujuanTamu = (EditText)findViewById(R.id.tujuanTxt);
        standbyTamu = (EditText)findViewById(R.id.standbyTxt);
        keteranganTamu = (EditText)findViewById(R.id.keteranganTxt);
        beginTimeTamu = (EditText)findViewById(R.id.begintimeTxt);
        endTimeTamu = (EditText)findViewById(R.id.endtimeTxt);
        listCustomersBox = (Spinner)findViewById(R.id.listCustomer);
        kePul = (CheckBox)findViewById(R.id.pulCheck);
        internal = (CheckBox)findViewById(R.id.internalCheck);
        fullday = (CheckBox)findViewById(R.id.fulldayCheck);

        String pulString = "", internalString = "", fulldayString = "";

        if(kePul.isChecked()){
            pulString = pulString + "pulChecked";
        }
        if(internal.isChecked()){
             internalString = internalString + "internalChecked";
        }
        if(fullday.isChecked()){
             fulldayString = fulldayString + "fulldayChecked";
        }

        String namaTamuString = namaTamu.getText().toString();
        String tujuanTamuString = tujuanTamu.getText().toString();
        String standbyTamuString = standbyTamu.getText().toString();
        String keteranganTamuString = keteranganTamu.getText().toString();
        String beginTimeTamuString = beginTimeTamu.getText().toString();
        String endTimeTamuString = endTimeTamu.getText().toString();
        String listCustomersString = String.valueOf(listCustomersBox.getSelectedItem());
        /*Test
        String pulString = kePul.getText().toString();
        String internalString = internal.getText().toString();
        String fulldayString = fullday.getText().toString();
        */



        //Create Bundle Objects
        Bundle extras = new Bundle();
        //Adding Key value pairs to this bundle
        extras.putString("listCustomers", listCustomersString);
        extras.putString("namaTamu", namaTamuString);
        extras.putString("tujuanTamu", tujuanTamuString);
        extras.putString("standbyTamu", standbyTamuString);
        extras.putString("keteranganTamu", keteranganTamuString);
        extras.putString("beginTamu", beginTimeTamuString);
        extras.putString("endTamu", endTimeTamuString);
        extras.putString("date", dateInput);
        extras.putString("armada", armadaInput);
        //Test
        extras.putString("pul", pulString);
        extras.putString("fullday", fulldayString);
        extras.putString("internal", internalString);

        Intent moveToHasilBooking = new Intent(PickingCalendarActivity.this, HasilBooking.class);
        moveToHasilBooking.putExtras(extras);
        startActivity(moveToHasilBooking);

    }

}
