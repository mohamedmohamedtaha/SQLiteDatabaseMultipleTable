package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
         Date date=null;

        try {
            Date startDate = format.parse("2010-11");
            Date endDate = format.parse("2011-6");

            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            Calendar end =Calendar.getInstance();
            end.setTime(endDate);
            int count =0;
            /*
            while (start.before(end)){
                date =start.getTime();
                start.add(Calendar.MONTH,12);
            }                count++;
*/
             for ( date = start.getTime(); start.before(end); start.add(Calendar.MONTH,1),date=start.getTime()){
                count ++;
           }
           int a=count/6;
          end.add(Calendar.MONTH,-a);
            Date ww=end.getTime();

                    Toast.makeText(getApplicationContext(),"Date Final"+date+"Number:"+count+"Sum:"+count*1000+"By"+a+"Date After:"+ww,Toast.LENGTH_LONG).show();




        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}



















