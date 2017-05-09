package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.model.Post;

import java.util.List;

/**
 * Created by mark63 on 10/5/17.
 */

public class PostAdapterBase extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Post> posts;
    private Context context;
    private int id;

    /**
     * @param posts   posts list
     * @param context context of activity
     * @param id      id
     */
    public PostAdapterBase(final List<Post> posts, final Context context, final int id) {
        this.posts = posts;
        this.context = context;
        this.id = id;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.post_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Post currentUser = posts.get(position);
        if (id == currentUser.getUserId()) {
            viewHolder.tvId.setText(String.valueOf(currentUser.getId()));
            viewHolder.tvTitle.setText(currentUser.getTitle());
            viewHolder.tvDescribe.setText(currentUser.getBody());
        }


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    /**
     * abc
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvId;
        private TextView tvDescribe;

        /**
         * @param itemView itemview
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvDescribe = (TextView) itemView.findViewById(R.id.user_describe);
            tvId = (TextView) itemView.findViewById(R.id.user_id);
            tvTitle = (TextView) itemView.findViewById(R.id.user_title);

        }
    }
}
