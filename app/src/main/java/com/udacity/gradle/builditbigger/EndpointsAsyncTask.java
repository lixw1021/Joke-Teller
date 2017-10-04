package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.joke.backend.jokeBeanApi.JokeBeanApi;
import com.xianwei.jokedisplay.JokeActivity;

import java.io.IOException;

/**
 * Created by xianwei li on 10/3/2017.
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokeBeanApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {
            JokeBeanApi.Builder builder =
                    new JokeBeanApi
                            .Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                            .setRootUrl("https://joke-181915.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getJokeBean().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, result);
        context.startActivity(intent);
    }
}
