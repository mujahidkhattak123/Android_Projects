package com.cal.retrofit_glide_recycler_view;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Resquest_Interface {
    @GET("get/cfXXzTDdIO?indent=2")
    Call<JsonResponse> getJSON();

}

