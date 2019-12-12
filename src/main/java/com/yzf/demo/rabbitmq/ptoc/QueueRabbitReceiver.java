package com.yzf.demo.rabbitmq.ptoc;

import com.yzf.demo.rabbitmq.MQConst;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * QueueRabbitReceiver
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Component
public class QueueRabbitReceiver {
    @RabbitListener(queues = MQConst.QUEUE_ZERO)
    @RabbitHandler
    public void process1(String message){
        System.out.println("queue 1 received: " + message);
    }

    @RabbitListener(queues = MQConst.QUEUE_ZERO)
    @RabbitHandler
    public void process2(String message){
        System.out.println("queue 2 received: " + message);
    }
}
