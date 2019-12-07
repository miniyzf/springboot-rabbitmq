package com.yzf.demo.rabbitmq.fanout;

import com.yzf.demo.rabbitmq.MQConst;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FanoutProducer
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Component
public class FanoutProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFanout(String message){
        this.rabbitTemplate.convertAndSend(MQConst.FANOUT_EXCHANGE,"",message);
        System.out.println("fanout sent: " + message);
    }
}
