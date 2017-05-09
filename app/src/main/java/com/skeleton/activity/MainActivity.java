package com.skeleton.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.skeleton.R;
import com.skeleton.adapter.Mainadapter;
import com.skeleton.model.UserInfo;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * main activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 *  handle data from server
 */
        RestClient.getApiInterface().getuserMethod().enqueue(new ResponseResolver<List<UserInfo>>(this) {
            @Override
            public void success(final List<UserInfo> userInfos) {
                Mainadapter mainadapter = new Mainadapter(userInfos, MainActivity.this);
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_main);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(mainadapter);
            }

            @Override
            public void failure(final APIError error) {

            }
        });
    }
}
