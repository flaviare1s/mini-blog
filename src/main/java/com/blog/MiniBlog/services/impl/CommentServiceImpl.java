package com.blog.MiniBlog.services.impl;

import com.blog.MiniBlog.models.Comment;
import com.blog.MiniBlog.services.CommentService;
import com.blog.MiniBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    // @Autowired
    // private AmqpTemplate amqpTemplate;

    @Autowired
    private UserService userService;

    @Value("${FrameBlog.rabbitmq.exchange}")
    private String exchange;

    @Value("${FrameBlog.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public Comment send(Comment comment) {
        comment.setUser(userService.get(comment.getUser().getUserId()));

        // amqpTemplate.convertAndSend(exchange, routingkey, comment);
        System.out.println("Send msg = " + comment);
        return comment;
    }
}
