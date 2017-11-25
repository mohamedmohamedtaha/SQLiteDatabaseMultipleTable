package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    // Database Helper
    DatabaseHelper db;
    Button tagBT,todoBt,getListTagBT,getListTodoBT,getListTODOTAG;
    EditText tagET,todoET;
    Spinner spinner;
    String tagSpinner;
    long idSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      db = new DatabaseHelper(getApplicationContext());


/*
        AlarmManager alarms =(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

        NotificationSettings receiver = new NotificationSettings();
        IntentFilter filter =new IntentFilter("ALARM_ACTION");
        registerReceiver(receiver,filter);
        Intent intent  =new Intent("ALARM_ACTION");

        PendingIntent operation = PendingIntent.getBroadcast(this,0,intent,0);

        alarms.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+3000,operation);
        */

        //Another solve
        Calendar calendar =Calendar.getInstance();
        //Set Time

        //   calendar.set(Calendar.HOUR_OF_DAY,15);
       // calendar.set(Calendar.MINUTE,16);
       // calendar.set(Calendar.SECOND,0);
        Intent alertIntent =new Intent(getApplicationContext(),NotificationSettings.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
     //   alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));
       //Repeat alarm
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));
        //Cancel Alarm
      //  alarmManager.cancel(PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));


    //    Calendar calendar =Calendar.getInstance();

      //  Intent alertIntent =new Intent(getApplicationContext(),NotificationSettings.class);
       // AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));



/*
try {
        boolean alarm =(PendingIntent.getBroadcast(this,0,new Intent("ALARM"),PendingIntent.FLAG_NO_CREATE)==null);
        if (alarm){
            Intent itAlarm =new Intent("ALARM");
            PendingIntent pendingIntent =PendingIntent.getBroadcast(this,0,itAlarm,0);
            Calendar calender = Calendar.getInstance();
            calender.setTimeInMillis(System.currentTimeMillis());
            calender.add(Calendar.SECOND,3);
            AlarmManager alarme = (AlarmManager)getSystemService(ALARM_SERVICE);
            alarme.set(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis()+(3*1000),pendingIntent);
        }else {
           Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_LONG).show();
        }}
catch (Exception e){
    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

}*/
             //addNotification();


        spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        loadSpinnerData();

        tagBT =(Button)findViewById(R.id.tagBT);
        todoBt =(Button)findViewById(R.id.todoBT);

        getListTagBT=(Button)findViewById(R.id.getListTagBT);
        getListTodoBT=(Button)findViewById(R.id.getListTodoBT);
        getListTODOTAG=(Button)findViewById(R.id.getListTODOTAG);

        tagET=(EditText)findViewById(R.id.tagET);
        todoET=(EditText)findViewById(R.id.todoET);

    }
    public void saveTAG(View view){
        if (tagET.getText().toString().trim().length()<=0){
            Toast.makeText(getApplicationContext(),"Enter data",Toast.LENGTH_LONG).show();

        }else {
            Tag tag = new Tag();
            tag.setTag_name(tagET.getText().toString());
            db.createTag(tag);
            Toast.makeText(getApplicationContext(),"Saved Succeflly",Toast.LENGTH_LONG).show();

        }




    }
    public void saveTODO(View view){
        if (todoET.getText().toString().trim().length()<=0){
            Toast.makeText(getApplicationContext(),"Enter data",Toast.LENGTH_LONG).show();

        }else {
            Todo todo =new Todo();
            todo.setNote(todoET.getText().toString());
            todo.setStatus(1);
            db.createToDo(todo,new long []{idSpinner});
            Toast.makeText(getApplicationContext(),"Saved Succeflly",Toast.LENGTH_LONG).show();

        }

    }
    public void getListTag(View view){
        Intent intent=new Intent(MainActivity.this,ListTAGActivity.class);
        startActivity(intent);

    }
    public void getListTodo(View view){
        Intent intent=new Intent(MainActivity.this,ListTODOActivity.class);
        startActivity(intent);

    }
    public void getListTodoTag(View view){
        Intent intent=new Intent(MainActivity.this,ListTodoTagActivity.class);
        intent.putExtra("getValueSpinner",tagSpinner);
        startActivity(intent);

    }
    public void loadSpinnerData(){
        //Spinner Drop down elements
        ArrayList<String> tag = db.getDataForSpinner();
        //Creating adapter for spinner
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tag);
        //Drop down layout style - list view with radio button
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        spinner.setAdapter(arrayAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //On selected a spinner iten
        tagSpinner = parent.getItemAtPosition(position).toString();
        idSpinner =parent.getItemIdAtPosition(position+1);
        //Showing selected spinner item
     //  Toast.makeText(parent.getContext(),"You Selected :"+tagSpinner+"ID:"+idSpinner,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onResume() {
        loadSpinnerData();
        super.onResume();
    }
    private void addNotification(){

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.passwordlow);
        builder.setContentTitle("Mohamed taha");
        builder.setContentText("How ara you");

        //Setting this flag will make it so the notification is automatically canceled when the user clicks it in the panel.
        builder.setAutoCancel(true);

        //Set the large text at the right-hand side of the notification.
        builder.setContentInfo("Menna Hassan");

     //   builder.setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE);
        builder.setNumber(20);
        builder.setOngoing(true);
      //  builder.setStyle(R.layout.);

        //Set the text that is displayed in the status bar when the notification first arrives.
        builder.setTicker("Asser Moahmed Taha");
        builder.setSubText("Sub Text");


        //builder.setWhen(2);
       // builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        Intent notificationIntent = new Intent(this,ListTAGActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        //Add Button
        builder.addAction(R.drawable.password,"Call",contentIntent);

        builder.setContentIntent(contentIntent);

        //Add as notification
        NotificationManager notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        //notificationId allows you to update the notification later on .
        int notificationID=0;
        notificationManager.notify(notificationID,builder.build());


    }

   }
