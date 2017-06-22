package ru.lubich.likeservice.model;

/**
 * Created by Евгений on 22.06.2017.
 */
public class isLiked {
    private Integer liked;

    public isLiked(Integer liked) {
        this.liked = liked;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }
}
