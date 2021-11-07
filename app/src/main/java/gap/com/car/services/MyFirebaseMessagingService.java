package gap.com.car.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import gap.com.car.R;
import gap.com.car.SplashActivity;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private Intent intent;

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("newToken=====", s);
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putString(Constants.FIRE_BASE_TOKEN, s);
        editor.apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        String body = remoteMessage.getNotification().getTitle();
        String title = remoteMessage.getNotification().getBody();

        if (remoteMessage.getNotification() != null){
            Intent intent = new Intent(this, SplashActivity.class);
            sendNotification(getApplicationContext(), title, body,intent);
        }

        System.out.println("data====" + data);
        System.out.println("data====" + body);
        System.out.println("data====" + title);

    }

    public static String getToken() {
        return CarApplication.getInstance().getSharedPreferences().getString(Constants.FIRE_BASE_TOKEN, "");
    }

    public void showNotification(Context context, String title, String body) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null) {
            int notificationId = 1;
            String channelId = "channel-01";
            String channelName = "Channel Name";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel mChannel = new NotificationChannel(
                        channelId, channelName, importance);
                notificationManager.createNotificationChannel(mChannel);
            }
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                    .setContentTitle(title)
                    .setContentText(body);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addNextIntent(intent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                    0,
                    PendingIntent.FLAG_UPDATE_CURRENT
            );
            mBuilder.setContentIntent(resultPendingIntent);
            mBuilder.setAutoCancel(true);
            assert notificationManager != null;
            notificationManager.notify(notificationId, mBuilder.build());
        }

    }


    private void sendNotification(Context context,String title,String body,Intent intent) {

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "default_notification_channel_id";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, channelId)
                        .setSmallIcon(R.drawable.notification_icon)
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
