package com.yzf.demo.rabbitmq.topic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yzf.demo.rabbitmq.MQConst;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

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



    public static void main(String[] args) {
        String s = "97,100,115,102,49,50,51,52,44,46,47,64,-26,-75,-117,-24,-81,-107,-27,-113,-111,-23,-128,-127,-25,-102,-124,-26,-74,-120,-26,-127,-81";
        String[] strs = s.split(",");
        int len = strs.length;
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[i] = Byte.parseByte(strs[i]);
        }
        try {
            String str = new String(bytes,"UTF-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
