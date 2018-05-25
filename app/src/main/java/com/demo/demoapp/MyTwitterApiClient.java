package com.demo.demoapp;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class MyTwitterApiClient extends TwitterApiClient {
    public MyTwitterApiClient(TwitterSession session) {
        super(session);
    }

    public GetUsersShowAPICustomService getCustomService() {
        return getService(GetUsersShowAPICustomService.class);
    }
}

interface GetUsersShowAPICustomService {
    @GET("/1.1/users/show.json")
    Call<User> show(@Query("user_id") long userId);

    @GET("/1.1/trends/place.json")
    Call<User> showtweets(@Query("id") long userId);
    /*
    * In retrofit v1 you could write like this
    *
    * @GET("/1.1/users/show.json")
    * void show(@Query("user_id") Long userId, Callback<User> cb);
    *
    * */
}