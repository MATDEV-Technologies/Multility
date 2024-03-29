package com.matdevtech.multility;

// Imports
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Main class
@SuppressWarnings({"deprecation"})
public class DailyFactAPIFetch extends AsyncTask<Void,Void,Void> {
    // Class var(s)
    String fact_data = "";

    @Override
    protected Void doInBackground(Void... voids) {
        //noinspection TryWithIdenticalCatches
        try {
            URL factURL = new URL("http://numbersapi.com/random");
            HttpURLConnection httpURLConnection = (HttpURLConnection) factURL.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String fact = "";
            while(fact != null){
                fact = bufferedReader.readLine();
                //noinspection StringConcatenationInLoop
                fact_data += fact;
            }
            fact_data = fact_data.substring(0, fact_data.length() - 4); // Remove "null"
            Log.e("fact_text", fact_data); // DEBUG
        }
        catch (MalformedURLException ignored) { }
        catch (IOException ignored) { }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (!this.fact_data.equals("")) {
            // Grab as HTML text to include proper formatting
            DailyFact.fact_text.setText(Html.fromHtml(this.fact_data));
        }
    }
}