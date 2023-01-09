package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
