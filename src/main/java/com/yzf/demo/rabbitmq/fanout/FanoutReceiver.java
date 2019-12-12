package com.yzf.demo.rabbitmq.fanout;

import com.yzf.demo.rabbitmq.MQConst;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FanoutReceiver
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = MQConst.FANOUT_QUEUE_ONE)
    @RabbitHandler
    public void process1(String message){
        System.out.println("fanout one Received: " + message);
    }

    @RabbitListener(queues = MQConst.FANOUT_QUEUE_TWO)
    @RabbitHandler
    public void process2(String message){
        System.out.println("fanout two Received: " + message);
    }

    @RabbitListener(queues = MQConst.FANOUT_QUEUE_THREE)
    @RabbitHandler
    public void process3(String message){
        System.out.println("fanout three Received: " + message);
    }
}
