package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by MANASATT on 25/05/17.
 */

public class NotificationSettings extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

     //   Intent it =new Intent(context,ListTODOActivity.class);
      //  createNotification(context,it,"new message","body","this is amessage");

        /*
        String [] All_Duaa = context.getResources().getStringArray(R.array.All_Duaa);
        Random Rnd = new Random();
        int NUM = Rnd.nextInt(All_Duaa.length);
        String Duaa_TXT = All_Duaa[NUM];

        //Action 1
        Intent intent_Page = new Intent(context,ListTAGActivity.class);
        //intent_Page.putExtra("Duaa_TXT",Duaa_TXT);
        PendingIntent pendOpen = PendingIntent.getActivity(context,22,intent_Page,PendingIntent.FLAG_UPDATE_CURRENT);

        //Not Action
        PendingIntent p = PendingIntent.getActivity(context, 0,new Intent(context,ListTODOActivity.class), 0);

        Bitmap bitmap_icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.notification);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.notification);
        builder.setLargeIcon(bitmap_icon);
        builder.setContentTitle("تذكير");
        builder.setContentText(Duaa_TXT);
        builder.addAction(R.drawable.replaybuttonlow,"تم الدفع",pendOpen);
        builder.addAction(R.drawable.exitbutton,"لم يتم الدفع",p);
        builder.setContentIntent(p);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(1);
        nm.notify(1,builder.build());
*/


        /*
        //onther solve
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)){
            Intent serviceIntent = new Intent(context,MyService.class);
            context.startService(serviceIntent);
        }*/
        /*

       if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
            Intent serviceIntent =new Intent("com.example.manasatt.sqlitedatabasewithmultipletables.MyService");
            context.startService(serviceIntent);
        }*/


              try {

                  //Set Time
                  String yourHour = "15:06";
                  SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
                  String curr =hour.format(Calendar.getInstance().getTime());


                  //set Date
                  String yourDate = "2/06/2017";
                  SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                  Date resultDate = null;
                  try{
                      resultDate= date.parse(yourDate);
                  } catch (ParseException e) {
                      e.printStackTrace();
                  }

            //      if (new Date().after(resultDate)&& curr.equals(yourHour)){
                          Intent it =new Intent(context,ListTODOActivity.class);
                          createNotification(context,it,"new message","body","this is amessage");
              //     }
             // else {
               //       Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();

                 //         }
        }catch (Exception e){
          //  Log.i("date:","error == "+e.getMessage());
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();

        }
  //      Toast.makeText(context,intent.getStringExtra("param"),Toast.LENGTH_LONG).show();
    }
    public void createNotification(Context context,Intent intent,CharSequence ticker,CharSequence title,CharSequence descricao){
        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(context, 0,intent, 0);

        Intent intent_Page = new Intent(context,ListTAGActivity.class);
        //intent_Page.putExtra("Duaa_TXT",Duaa_TXT);
        PendingIntent pendOpen = PendingIntent.getActivity(context,22,intent_Page,PendingIntent.FLAG_UPDATE_CURRENT);


        Bitmap bitmap_icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.notificationlow);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker(ticker);
        builder.setContentTitle(title);
        builder.setContentText(descricao);
        builder.setSmallIcon(R.drawable.notification);
        builder.setLargeIcon(bitmap_icon);
        builder.addAction(R.drawable.replaybuttonlow,"تم الدفع",pendOpen);
        builder.addAction(R.drawable.exitbutton,"لم يتم الدفع",p);
        builder.setContentIntent(p);
        builder.setAutoCancel(true);
        //Not Action
       // PendingIntent p = PendingIntent.getActivity(context, 0,new Intent(context,ListTODOActivity.class), 0);
      //  builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        Notification n = builder.build();
        //Create the notiffication
        n.vibrate = new long[]{150,300,150,400};
        n.flags =Notification.FLAG_AUTO_CANCEL;
        nm.notify(R.drawable.password,n);
        //create a vibration
        try{
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone =RingtoneManager.getRingtone(context,som);
            ringtone.play();
        }catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
  }
