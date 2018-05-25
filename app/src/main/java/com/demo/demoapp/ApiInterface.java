package com.demo.demoapp;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

//    @GET("api/{email}/{password}")
//    Call<Login> authenticate(@Path("email") String email, @Path("password") String password);
//
//    @POST("api/{email}/{password}")
//    Call<Login> registration(@Path("email") String email, @Path("password") String password);
//    @GET()
//    Call<PurchaseOrders> getData();



    @GET("/get/geo/search?q=orlando")
    Call<TweetsListActivity.Tweet> getPoServiceCall();

//    @GET("services/receivings/4969/poDetailsByStatus?poReceiveStatus=AF&mustArriveByStartDate=2018-01-08T00:00:00.000+0000&&mustArriveByEndDate=2018-09-20T00:00:00.000+0000")
//    Call<PoServiceCall1> getPoServiceCall1();

}
