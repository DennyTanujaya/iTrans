package com.pdes.itranstest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.nio.file.StandardWatchEventKinds;

public class HasilBooking extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_booking);
        TextView thecustomer = (TextView) findViewById(R.id.customerInput);
        TextView thenamatamu = (TextView) findViewById(R.id.namaTamuInput);
        TextView thetujuan = (TextView) findViewById(R.id.tujuanInput);
        TextView thestandby = (TextView) findViewById(R.id.standbyInput);
        TextView theketerangan = (TextView) findViewById(R.id.keteranganInput);
        TextView thebegin = (TextView) findViewById(R.id.beginInput);
        TextView theend = (TextView) findViewById(R.id.endInput);
        TextView thedate = (TextView) findViewById(R.id.dateInput);
        TextView thearmada = (TextView) findViewById(R.id.armadaInput);
        CheckBox theinternal = (CheckBox) findViewById(R.id.internalInput);
        CheckBox thekupul = (CheckBox) findViewById(R.id.kePulInput);
        CheckBox thefullday = (CheckBox) findViewById(R.id.fulldayInput);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String date = extras.getString("date");
        String armada = extras.getString("armada");
        String customer = extras.getString("listCustomers");
        String namaTamu = extras.getString("namaTamu");
        String tujuanTamu = extras.getString("tujuanTamu");
        String keteranganTamu = extras.getString("keteranganTamu");
        String standbyTamu = extras.getString("standbyTamu");
        String beginTamu = extras.getString("beginTamu");
        String endTamu = extras.getString("endTamu");
        String internalTamu = extras.getString("internal");
        String pulTamu = extras.getString("pul");
        String fulldayTamu = extras.getString("fullday");
        thedate.setText(date);
        thearmada.setText(armada);
        thecustomer.setText(customer);
        thenamatamu.setText(namaTamu);
        thetujuan.setText(tujuanTamu);
        thestandby.setText(standbyTamu);
        theketerangan.setText(keteranganTamu);
        thebegin.setText(beginTamu);
        theend.setText(endTamu);

        assert internalTamu != null;
        assert pulTamu != null;
        assert fulldayTamu != null;
        if(internalTamu.equals("internalChecked")) {
            theinternal.setChecked(true);
        }
        if(pulTamu.equals("pulChecked")) {
            thekupul.setChecked(true);
        }
        if(fulldayTamu.equals("fulldayChecked")) {
            thefullday.setChecked(true);
        }
    }

    public void goHome(View view) {
        Intent goToHome = new Intent(HasilBooking.this, BusActivity.class);
        startActivity(goToHome);
    }
}
