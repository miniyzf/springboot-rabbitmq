package com.yzf.demo.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TopicReceiverOne
 *
 * @author Administrator
 * @date 2019/12/5
 */
@Component
@RabbitListener(queues = "topic_queue_one")
public class TopicReceiverOne {

    @RabbitHandler
    public void process(String message){
        System.out.println("One Received: " + message);
    }
}
