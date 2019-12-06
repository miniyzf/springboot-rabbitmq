package com.yzf.demo.rabbitmq.ptoc;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * QueueReceiverOne
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Component
@RabbitListener(queues = "queue_zero")
public class QueueReceiverTwo {
    @RabbitHandler
    public void process(String message){
        System.out.println("queue 2 received: " + message);
    }
}
