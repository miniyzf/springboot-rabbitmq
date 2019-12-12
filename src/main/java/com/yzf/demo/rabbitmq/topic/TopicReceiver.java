package com.yzf.demo.rabbitmq.topic;

import com.yzf.demo.rabbitmq.MQConst;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TopicReceiver
 *
 * @author Administrator
 * @date 2019/12/5
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = MQConst.TOPIC_QUEUE_ONE)
    @RabbitHandler
    public void process1(String message) {
        System.out.println("One Received: " + message);
    }

    // application.properties 配置
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(
                    value = "${spring.rabbitmq.listener.order.queue.name}"
                    , durable = "${spring.rabbitmq.listener.order.queue.durable}")
            , exchange = @Exchange(
                    value = "${spring.rabbitmq.listener.order.exchange.name}"
                    , durable = "${spring.rabbitmq.listener.order.exchange.durable}"
                    , type = "${spring.rabbitmq.listener.order.exchange.type}"
                    , ignoreDeclarationExceptions = "${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}")
            , key = "${spring.rabbitmq.listener.order.key}"))
    @RabbitHandler
    public void process2(String message) {
        System.out.println("Two Received: " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(
                    value = MQConst.TOPIC_QUEUE_THREE, durable = "true"),
            exchange = @Exchange(
                    value = MQConst.TOPIC_EXCHANGE, durable = "true", type = "topic", ignoreDeclarationExceptions = "true"),
            key = MQConst.TOPIC_BINDING_KEY_ONE
    ))
    @RabbitHandler
    public void process3(String message) {
        System.out.println("Three Received: " + message);
    }
}
