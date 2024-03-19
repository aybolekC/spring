package com.aya.repository;

import com.aya.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);
}
