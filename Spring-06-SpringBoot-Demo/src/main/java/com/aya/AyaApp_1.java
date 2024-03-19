package com.aya;

import com.aya.model.Comment;
import com.aya.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AyaApp_1 {

    public static void main(String[] args) {
        Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

       ApplicationContext context=SpringApplication.run(AyaApp_1.class, args);

        CommentService cs=context.getBean(CommentService.class);
        cs.publishComment(comment);
    }

}
