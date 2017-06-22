package ru.lubich.likeservice.model;

/**
 * Created by Евгений on 21.06.2017.
 */


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;


@Entity
@Table(name = "likes")
public class Like {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "post_id", nullable = false)
    private Integer post_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;


    public Like(Integer post_id, Integer user_id) {
        this.post_id = post_id;
        this.user_id = user_id;
    }

    public Like() {
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }




}

