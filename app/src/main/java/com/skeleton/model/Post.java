package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mark63 on 10/5/17.
 */

public class Post {


    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    /**
     *
     * @return id
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId id
     */
    public void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id
     */

    public void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return id
     */

    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title title
     */

    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     *
     * @return title
     */

    public String getBody() {
        return body;
    }

    /**
     *
     * @param body body
     */

    public void setBody(final String body) {
        this.body = body;
    }
}
