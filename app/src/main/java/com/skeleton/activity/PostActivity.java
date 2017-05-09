package com.skeleton.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.skeleton.R;
import com.skeleton.adapter.PostAdapterBase;
import com.skeleton.model.Post;
import com.skeleton.model.UserInfo;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.Log;

import java.util.List;

/**
 * to display posts
 */
public class PostActivity extends AppCompatActivity {

    private int id;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        final Bundle bundle = getIntent().getBundleExtra("id");
        UserInfo obj = bundle.getParcelable("Object");
        id = obj.getId();

        RestClient.getApiInterface().getPosts(id).enqueue(new ResponseResolver<List<Post>>(this, true) {
            @Override
            public void success(final List<Post> posts) {

                Log.d("abc", String.valueOf(id));
                PostAdapterBase recyclerViewAdapter = new PostAdapterBase(posts, PostActivity.this, id);

                recyclerView = (RecyclerView) findViewById(R.id.rv_posts);
                recyclerView.setLayoutManager(new LinearLayoutManager(PostActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);


            }

            @Override
            public void failure(final APIError error) {

            }
        });

    }
}
