package com.skeleton.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.MainActivity;
import com.skeleton.fragment.MainFragement;
import com.skeleton.model.UserInfo;

import java.util.List;

/**
 * Created by mark63 on 9/5/17.
 */

public class Mainadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<UserInfo> userInfo;
    private Context context;
    private int mMode;

    /**
     * @param userInfo list
     * @param context  context
     */
    public Mainadapter(final List<UserInfo> userInfo, final Context context) {
        this.userInfo = userInfo;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_fragement, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserInfo currentUser = userInfo.get(position);

        viewHolder.id.setText(String.valueOf(currentUser.getId()));
        viewHolder.name.setText(currentUser.getName());

    }

    @Override
    public int getItemCount() {
        return userInfo.size();
    }

    /**
     * abc
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView id;

        /**
         * @param itemView itemview
         */

        public ViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_username);
            id = (TextView) itemView.findViewById(R.id.tv_userid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        MainFragement mainFragement = new MainFragement();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("Object", userInfo.get(pos));
                        mainFragement.setArguments(bundle);
                        FragmentManager fm = ((MainActivity) context).getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.details, mainFragement);
                        ft.commit();
                    }
                }
            });


        }


    }

}
