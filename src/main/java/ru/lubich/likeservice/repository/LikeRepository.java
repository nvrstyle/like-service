package ru.lubich.likeservice.repository;

/**
 * Created by Евгений on 21.06.2017.
 */
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lubich.likeservice.model.Like;

import java.math.BigInteger;
import java.util.List;


public interface LikeRepository extends CrudRepository<Like, Long> {
    @Query(value = "SELECT count(user_id) FROM likes WHERE post_id = ?1",
            countQuery = "SELECT count(user_id) FROM likes_test WHERE post_id = ?1",

            nativeQuery = true)
    BigInteger countByPost_Id(Integer post_id);

    @Query(value = "SELECT user_id FROM likes WHERE post_id = ?1",
            nativeQuery = true)
    Iterable<Integer> findByPost_Id(Integer post_id);

    @Query(value = "SELECT count(user_id) FROM likes WHERE post_id = ?1 AND user_id = ?2",
            countQuery = "SELECT count(user_id) FROM likes WHERE post_id = ?1 AND user_id = ?2",
            nativeQuery = true)
    BigInteger countIsLiked(Integer post_id, Integer user_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM likes WHERE post_id = ?1 AND user_id = ?2", nativeQuery = true)
    void DeleteLike(Integer post_id, Integer user_id);
}
