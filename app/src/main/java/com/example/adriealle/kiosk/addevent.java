package com.example.adriealle.kiosk;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class addevent extends AppCompatActivity {

    String time1,time2;

    TextView tim1,tim2,fromtext,totext;
    ImageButton b1,b2,from,to;

    Button b4;

    EditText eventname;

    int check1,check2=0,check3=0,check4=0;
    int mHour,Hour,day,month,year;
    int mMinute,Minute;
    String time,todate,fromdate ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);

        //et_show_date_time = (EditText) findViewById(R.id.ed1);
        b1 = (ImageButton) findViewById(R.id.b1);
        b2 = (ImageButton) findViewById(R.id.b2);


        from = (ImageButton) findViewById(R.id.from);
        to = (ImageButton) findViewById(R.id.to);





        b4 = (Button) findViewById(R.id.b4);
        tim1= (TextView)findViewById(R.id.tv3);
        tim2= (TextView)findViewById(R.id.tv5);


        eventname= (EditText)findViewById(R.id.editText);

        fromtext= (TextView)findViewById(R.id.textView2);
        totext= (TextView)findViewById(R.id.textView3);



        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check3=1;
                datepicker(1);
            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check4=1;
                datepicker(2);
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                check1=1;
                timePicker(1);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                check2=1;
                timePicker(2);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(check1==1&&check2==1&&check3==1&&check4==1) {
                    new AlertDialog.Builder(addevent.this)
                            .setMessage("have you checked everything?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    eventdata tb=new eventdata(addevent.this);
                                    tb.addevent(eventname.getText().toString(),fromdate,todate,time1,time2);
                                    toaster("Event added");
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();



                }
                else if(check1==0&&check2==1&&check4==1&&check3==1)
                    toaster("Enter Start Time");
                else if(check1==1&&check2==0&&check4==1&&check3==1)
                    toaster("Enter Finish Time");

                else if(check1==1&&check2==1&&check3==1&&check4==0)
                    toaster("Enter End Date");
                else
                {
                    toaster("Enter All Details");
                }
            }
        });
    }


    public void toaster(String s){

        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

    }


    private void timePicker(final int i) {

        final java.util.Calendar c = java.util.Calendar.getInstance();
        mHour = c.get(java.util.Calendar.HOUR_OF_DAY);
        mMinute = c.get(java.util.Calendar.MINUTE);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Hour = hourOfDay;
                        Minute = minute;

                        time=hourOfDay + ":" + minute;
                        if(i==1) {
                            time1=time;
                            tim1.setText(time);
                        }
                        else if(i==2){
                            time2=time;
                            tim2.setText(time);
                        }
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }



    private void datepicker(final int f){
        final java.util.Calendar c = java.util.Calendar.getInstance();
        day= c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int years, int monthofyear, int dayofmonth) {
                        if (f==1){
                            fromdate=dayofmonth+"/"+monthofyear+"/"+years;
                            fromtext.setText("From: "+fromdate);

                        }

                        if (f==2){
                            todate=dayofmonth+"/"+monthofyear+"/"+years;
                            totext.setText("To: "+todate);

                        }

                    }

                },year,month,day);
        datePickerDialog.show();
    }
}

