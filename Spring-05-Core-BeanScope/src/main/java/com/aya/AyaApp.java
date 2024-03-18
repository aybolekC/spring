package com.aya;

import com.aya.config.ProjectConfig;
import com.aya.model.Comment;
import com.aya.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AyaApp {

    public static void main(String[] args) {


        Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

//        CommentService cs1=context.getBean(CommentService.class);
//        CommentService cs2=context.getBean(CommentService.class);
//
//        System.out.println(cs1);
//        System.out.println(cs2);
//
//        System.out.println(cs1==cs2);




    }
}
