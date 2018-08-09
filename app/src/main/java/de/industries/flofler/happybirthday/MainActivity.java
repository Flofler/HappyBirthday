package de.industries.flofler.happybirthday;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    final static String CHANNEL_ID = "Common";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withLocale(Locale.GERMAN)
                .withZone( ZoneId.systemDefault() );
        ZonedDateTime date = ZonedDateTime.parse("2018-08-09 22:11:00", formatter);
        Instant time = Instant.from(date);

        createNotificationChannel();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.heart)
                .setContentTitle("Ich liebe dich!")
                .setContentText("Klicke hier...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        final int notificationId = 123;
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.notify(notificationId, mBuilder.build());


        //Intent intent = new Intent(this, Receiver.class);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 001, intent, 0);

        //AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        //am.set(AlarmManager.RTC_WAKEUP, time.toEpochMilli(), pendingIntent);

        setContentView(R.layout.activity_main);





    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    /** Called when the user taps the Send button */
    public void clickButton(View view) {
        // Do something in response to button

        Intent intent = new Intent(this, DisplayReasonsActivity.class);
        startActivity(intent);
    }
}
