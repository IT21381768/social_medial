package com.cbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cbc.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
