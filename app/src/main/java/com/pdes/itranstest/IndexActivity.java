package com.pdes.itranstest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.TimeZone;

public class IndexActivity extends AppCompatActivity {

    private static final String TAG = "IndexActivity";
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        TextView armadaLabel = (TextView) findViewById(R.id.typeBusLabel);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String typeBus = extras.getString("typeBus");
        armadaLabel.setText(typeBus);


        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //String date = year + "/" + month + "/" +dayOfMonth;
                String date = dayOfMonth + " - " + (month + 1 ) + " - " + year;
                Log.d(TAG, "onSelectedDayChange: " + date);
                Intent dateMove = new Intent(IndexActivity.this, PickingCalendarActivity.class);
                dateMove.putExtra("date", date);
                startActivity(dateMove);


                //Create Bundle Objects
                Bundle extras = new Bundle();
                //Adding Key value pairs to this bundle
                extras.putString("date", date);
                extras.putString("armada", typeBus);

                Intent moveToPickingCalendarActivity = new Intent(IndexActivity.this, PickingCalendarActivity.class);
                moveToPickingCalendarActivity.putExtras(extras);
                startActivity(moveToPickingCalendarActivity);
            }
        });
    }
}
