package com.ruchitha.menusalertspickersexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b_datepicker,b_timepicker;
    int c_year,c_month,c_date;
    int mhours,mminutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_datepicker=findViewById(R.id.datepicker);
        b_timepicker=findViewById(R.id.timepicker);
        b_datepicker.setOnClickListener(this);
        b_timepicker.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlert();
                Toast.makeText(this,"you clicked alert item",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ap:
                Toast.makeText(this,"Hello Apssdc",Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this,"search clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void showAlert()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert...!");
        builder.setMessage("Do you want to close the app?");
        builder.setIcon(R.drawable.ic_baseline_add_alert_24);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        builder.show();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.datepicker:
                openDatepicker();
                break;
            case R.id.timepicker:
                openTimepicker();
                break;
        }
    }

    private void openTimepicker() {
        Calendar c=Calendar.getInstance();
        mhours=c.get(Calendar.HOUR_OF_DAY);
        mminutes=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String mytime=i+":"+i1;
                Toast.makeText(MainActivity.this, "Time is"+mytime, Toast.LENGTH_SHORT).show();
            }
        },mhours,mminutes,false);
        timePickerDialog.show();
    }

    private void openDatepicker() {
        Calendar c=Calendar.getInstance();
        c_year=c.get(Calendar.YEAR);
        c_month=c.get(Calendar.MONTH);
        c_date=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
                String mydate=dayofmonth+"-"+(monthofyear+1)+"-"+year;
                Toast.makeText(MainActivity.this, "Today's date is"+mydate, Toast.LENGTH_SHORT).show();
            }
        },c_year,c_month,c_date);
        datePickerDialog.show();
    }
}