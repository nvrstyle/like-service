package ru.lubich.likeservice.model;

/**
 * Created by Евгений on 22.06.2017.
 */
public class PostLike {
    private Integer post_id;
    private Integer user_id;

    public PostLike(Integer post_id, Integer user_id) {
        this.post_id = post_id;
        this.user_id = user_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
