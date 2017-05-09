package com.skeleton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.PostActivity;
import com.skeleton.model.UserInfo;

/**
 * Created by mark63 on 10/5/17.
 */

public class MainFragement extends Fragment {
    private TextView tvId;
    private TextView tvName;
    private Button btnPost;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_below, container, false);
        tvId = (TextView) view.findViewById(R.id.user_id);
        tvName = (TextView) view.findViewById(R.id.user_name);

        final Bundle bundle = getArguments();
        UserInfo object = bundle.getParcelable("Object");
        tvId.setText(String.valueOf(object.getId()));
        tvName.setText(object.getName());
        btnPost = (Button) view.findViewById(R.id.btn_posts);
        btnPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                intent = new Intent(getContext(), PostActivity.class);
                intent.putExtra("id", bundle);
                startActivity(intent);
            }
        });


        return view;
    }
}
