package com.example.example03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context myContext;
    Toast myToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = getApplicationContext();
        myToast = new Toast(myContext);
        myToast.makeText(myContext, "I am a Toast!",Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("This is a neutral Menu");
        dialogConf.setMessage("This is the Text of the Dialog");
        dialogConf.setIcon(R.mipmap.ic_launcher);
        dialogConf.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                myToast.makeText(myContext, "You Clicked Dismiss",Toast.LENGTH_LONG).show();
            }
        });
        dialogConf.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                myToast.makeText(myContext, "You Clicked Yes",Toast.LENGTH_LONG).show();
            }
        });
        dialogConf.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                myToast.makeText(myContext, "You Clicked No",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog myDialog = dialogConf.create();
        myDialog.show();

        Notification.Builder notifConf = new Notification.Builder(this);
        notifConf.setContentTitle("This is my shiny notification");

        notifConf.setContentText("This is the detail of the notification");
        notifConf.setSmallIcon(R.mipmap.ic_launcher);

        Intent myIntent = new Intent(this, ChildActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(myContext,0, myIntent,0);
        notifConf.setContentIntent(contentIntent);

        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(12344544, notifConf.build());

    }


}


















