package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {
    TextView showAlart;
    Button setDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        showAlart = (TextView) findViewById(R.id.showAlart);
        setDate = (Button) findViewById(R.id.setDate);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar c = Calendar.getInstance();
        if (id==1)
            return  new TimePickerDialog(NotificationActivity.this,TimeMap,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false);
        return null;
    }
    protected TimePickerDialog.OnTimeSetListener TimeMap =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                    calendar.set(Calendar.MINUTE,minute);
                    calendar.set(Calendar.SECOND,0);

                    Intent alertIntent =new Intent(getApplicationContext(),NotificationSettings.class);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));

                    showAlart.setText(hourOfDay + ":" + minute);

            }};
    public void alartNotification(View view){
        showDialog(1);
    }


}
