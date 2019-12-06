package com.yzf.demo.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TopicReceiverTwo
 *
 * @author Administrator
 * @date 2019/12/5
 */
@Component
@RabbitListener(queues = "topic_queue_two")
public class TopicReceiverTwo {

    @RabbitHandler
    public void process(String message){
        System.out.println("Two Received: " + message);
    }
}
