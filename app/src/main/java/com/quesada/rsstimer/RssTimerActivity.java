package com.quesada.rsstimer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;



public class RssTimerActivity extends Activity {

    private Timer timer;
    private TimerTask timertask;

    private final Handler handler = new Handler();

    /*private final String URL_STRING = "http://rss.cnn.com/rss/cnn_tech.rss";
    private final String FILENAME = "news_feed.xml";
    private Context context = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_timer);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void startTimer(View v) {

        timer = new Timer();

        initializeTimerTask();

        timer.schedule(timertask, 0, 10000);

    }

    public void stopTimerTask(View v) {

        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timertask = new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        /*try{
                            // get the URL
                            URL url = new URL(URL_STRING);

                            // get the input stream
                            InputStream in = url.openStream();

                            // get the output stream
                            FileOutputStream out =
                                    context.openFileOutput(FILENAME, Context.MODE_PRIVATE);

                            // read input and write output
                            byte[] buffer = new byte[1024];
                            int bytesRead = in.read(buffer);
                            while (bytesRead != -1)
                            {
                                out.write(buffer, 0, bytesRead);
                                bytesRead = in.read(buffer);
                            }
                            out.close();
                            in.close();
                        }
                        catch (IOException e) {
                            Log.e("News reader", e.toString());
                        }*/

                        final String displayRSS = "File Downloaded";

                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), displayRSS, duration);
                        toast.show();

                    }
                });
            }
        };
    }

}
