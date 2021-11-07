package gap.com.car.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import gap.com.car.R;
import gap.com.car.SplashActivity;
import gap.com.car.app.CarApplication;

import static android.content.Context.MODE_PRIVATE;

public class FirebaseDataReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void onReceive(Context context, Intent intent) {

        if (intent.getExtras() != null) {
            String action = String.valueOf(intent.getExtras().get("action"));
            String title = String.valueOf(intent.getExtras().get("gcm.notification.title"));
            String body = String.valueOf(intent.getExtras().get("gcm.notification.body"));
            if (action != null && action.equals("newMessage")) {
                SharedPreferences.Editor editor = context.getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                editor.putString("action", action);
                editor.apply();
            }
            if (!CarApplication.appIsRunning(context)) {
                intent = new Intent(context, SplashActivity.class);
            }
            showNotification(context, title, body, intent);
        }
        abortBroadcast();


       /* this.context = context;
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Set<String> keys = intent.getExtras().keySet();

            Log.d(TAG, "Refreshed keys: " + keys);

            for (String key : bundle.keySet()) {
                Object value = bundle.get("action");
                Log.d(TAG, "key===: " + key);
                Log.d(TAG, "Refreshed value1: " + value);
                // You can use key and values here
                if (value != null && value.equals("newMessage")) {
                    SharedPreferences.Editor editor = context.getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                    editor.putString("action", String.valueOf(value));
                    editor.apply();
                }
            }
            sendNotification(context, "title", "body", intent);
        }*/
    }

    private void sendNotification(Context context, String title, String body, Intent intent) {

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "default_notification_channel_id";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, channelId)
                        .setSmallIcon(R.drawable.ic_notify)
                        .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                        .setContentTitle(title)
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }


        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    private void showNotification(Context context, String title, String body, Intent intent) {

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "default_notification_channel_id";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, channelId)
                        .setSmallIcon(R.drawable.ic_notify)
                        .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                        .setContentTitle(title)
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

}
