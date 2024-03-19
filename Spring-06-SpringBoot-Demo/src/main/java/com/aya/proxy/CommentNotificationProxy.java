package com.aya.proxy;

import com.aya.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
