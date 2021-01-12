package com.cal.retrofit_glide_recycler_view;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<AndroidVersion> data;
    private DataAdapter adapter;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        //recyclerView.addOnItemTouchListener(new RecyclerItemCli);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
        loadJSON();

    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RequestInterface request= retrofit.create(RequestInterface.class);
        Call<JsonResponse> call = request.getJSON();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response.isSuccessful()){
                    pb.setVisibility(View.INVISIBLE);
                    JsonResponse res = response.body();
                    data = new ArrayList<>(Arrays.asList(res.getAndroid()));
                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Failure", t.getMessage());
            }
        });
    }
}
