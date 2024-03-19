package com.aya.service;

import com.aya.model.Comment;
import com.aya.proxy.CommentNotificationProxy;
import com.aya.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy
public class CommentService {

//    @Value("${name}")
//    private String x;
//
//    @Value("${days}")
//    private String[] days;

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;


    //@Autowired - it is there by default, no need to specify
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        System.out.println("Hello");
    }


    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }

}
