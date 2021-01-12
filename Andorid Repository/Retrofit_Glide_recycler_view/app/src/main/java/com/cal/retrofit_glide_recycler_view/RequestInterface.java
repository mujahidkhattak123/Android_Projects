package com.cal.retrofit_glide_recycler_view;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pronious on 26/09/2017.
 */

public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JsonResponse> getJSON();
}
