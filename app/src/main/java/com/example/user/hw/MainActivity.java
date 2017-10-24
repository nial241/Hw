package com.example.user.hw;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private JSONTask jsTask;
    private static final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/forecast/daily?id=524901&units=metric";
    private String[] str_arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsTask = new JSONTask();
        jsTask.execute(OPEN_WEATHER_MAP_API);
    }

    private class JSONTask extends AsyncTask<String, String, RenderJS> {

        @Override
        protected RenderJS doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;
            RenderJS re = new RenderJS();
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("x-api-key", "2a023dcd620e0366f307ef8e8fb4c823");
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder buf = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    buf.append(line);
                }

                re.Render(new JSONObject(buf.toString()));

                if (str_arr == null)
                    Thread.sleep(5000);

                return re;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.getLocalizedMessage();
            } catch (JSONException e) {
                e.getMessage();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return re;
        }

        @Override
        protected void onPostExecute(final RenderJS result) {
            super.onPostExecute(result);

            TextView txt = (TextView) findViewById(R.id.textView);
            txt.setText("Прогноз погоды в Москве на 7 дней");

            ListView listView = (ListView) findViewById(R.id.listView);
            if (result != null && str_arr == null) {
                str_arr = new String[7];
                for (int i = 0; i < 7; i++)
                    str_arr[i] = result.getDay(i);

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    str_arr);
            listView.setAdapter(adapter);
        }
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        str_arr = savedInstanceState.getStringArray("str_arr");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArray("str_arr", str_arr);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (jsTask != null) {
            jsTask.cancel(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (jsTask != null) {
            jsTask.cancel(true);
        }
    }
}
