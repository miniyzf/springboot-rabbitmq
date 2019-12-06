package com.yzf.demo.rabbitmq.topic;

import com.yzf.demo.rabbitmq.RabbitCommon;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TopicProducer
 *
 * @author Administrator
 * @date 2019/12/5
 */
@Component
public class TopicProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRoutingKeyOne(String message){
        this.rabbitTemplate.convertAndSend(RabbitCommon.TOPIC_EXCHANGE, RabbitCommon.TOPIC_ROUTING_KEY_ONE,message);
        System.out.println(" Sender: " + message);
    }

    public void sendRoutingKeyTwo(String message){
        this.rabbitTemplate.convertAndSend(RabbitCommon.TOPIC_EXCHANGE, RabbitCommon.TOPIC_ROUTING_KEY_TWO,message);
        System.out.println("Sender: " + message);
    }

}
