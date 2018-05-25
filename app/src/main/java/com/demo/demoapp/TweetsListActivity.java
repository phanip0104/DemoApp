package com.demo.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TweetsListActivity extends Activity {
    public static final String BASE_URL = "https://api.twitter.com/1.1/";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweet_layout);

        getDataWithRetrofit();


    }

    private ApiInterface getInterfaceService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }

    private void getDataWithRetrofit() {

        ApiInterface mApiService = this.getInterfaceService();
        Call<Tweet> mService = mApiService.getPoServiceCall();

        mService.enqueue(new Callback<Tweet>() {
            @Override
            public void onResponse(Call<Tweet> call, Response<Tweet> response) {

                Tweet twitter = response.body();
            }

            @Override
            public void onFailure(Call<Tweet> call, Throwable t) {
                call.cancel();

                Toast.makeText(TweetsListActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });

    }

    class Tweet {
        String text;
    }
    }
