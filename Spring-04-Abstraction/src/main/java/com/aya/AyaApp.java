package com.aya;

import com.aya.model.Comment;
import com.aya.model.config.ProjectConfig;
import com.aya.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AyaApp {

    public static void main(String[] args) {

        Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService=context.getBean(CommentService.class);
        commentService.publishComment(comment);


    }
}
