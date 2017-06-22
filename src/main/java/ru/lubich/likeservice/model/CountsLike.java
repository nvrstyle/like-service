package ru.lubich.likeservice.model;

import java.math.BigInteger;

/**
 * Created by Евгений on 22.06.2017.
 */
public class CountsLike {
    private BigInteger likes_count;

    public CountsLike(BigInteger likes_count) {
        this.likes_count = likes_count;
    }

    public BigInteger getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(BigInteger likes_count) {
        this.likes_count = likes_count;
    }
}
