package com.yzf.demo.rabbitmq.ptoc;

import com.yzf.demo.rabbitmq.RabbitCommon;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * QueueRabbitProducer
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Component
public class QueueRabbitProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendQueue(String message){
        this.rabbitTemplate.convertAndSend(RabbitCommon.QUEUE_ZERO,message);
        System.out.println("sent to queue: " + message);
    }

}
