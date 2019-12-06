package com.yzf.demo.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FanoutReceiverOne
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Component
@RabbitListener(queues = "fanout_queue_two")
public class FanoutReceiverTwo {
    @RabbitHandler
    public void process(String message){
        System.out.println("fanout two Received: " + message);
    }
}
