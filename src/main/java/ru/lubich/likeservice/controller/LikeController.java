package ru.lubich.likeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.lubich.likeservice.model.*;
import ru.lubich.likeservice.repository.LikeRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @RequestMapping(value = "/likes", method = RequestMethod.GET)
    public @ResponseBody Iterable<Like> getAllLike() {


        // This returns a JSON or XML with the users

        return likeRepository.findAll();


    }

    @RequestMapping(value = "/likes", method = RequestMethod.POST)
    public @ResponseBody CountsLike postLike(@RequestBody Like postlike) {

        //UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));
        likeRepository.save(postlike);
        // This returns a JSON or XML with the users

        CountsLike countsLike = new CountsLike(likeRepository.countByPost_Id(postlike.getPost_id()));

        return countsLike;
    }

    @RequestMapping(value = "/likes/{post_id}/user/{user_id}", method = RequestMethod.DELETE)
    public @ResponseBody CountsLike DeleteLike(@PathVariable("post_id") Integer post_id,
                                               @PathVariable("user_id") Integer user_id) {

        //UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));
        likeRepository.DeleteLike(post_id, user_id);
        // This returns a JSON or XML with the users

        CountsLike countsLike = new CountsLike(likeRepository.countByPost_Id(post_id));

        return countsLike;
    }


    @RequestMapping(value = "/likes/{post_id}", method = RequestMethod.GET)
    public @ResponseBody UserLike getCountLike(@PathVariable("post_id") Integer post_id) {

        UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));

        // This returns a JSON or XML with the users

        return userlike;
    }

    @RequestMapping(value = "/likes/isLiked/{post_id}/user/{user_id}", method = RequestMethod.GET)
    public @ResponseBody isLiked getisLiked(@PathVariable("post_id") Integer post_id,
                                            @PathVariable("user_id") Integer user_id) {

        UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));
        Iterable<Like> ListItems = new ArrayList<Like>();
        // This returns a JSON or XML with the users
        isLiked isliked;
        if (likeRepository.countIsLiked(post_id,user_id).intValue()>0)
        {
            isliked = new isLiked(1);
        }
        else
        {
            isliked = new isLiked(0);
        }
        return isliked;
    }
}




