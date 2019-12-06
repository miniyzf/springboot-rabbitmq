package com.yzf.demo.rabbitmq.ptoc;

import com.yzf.demo.rabbitmq.RabbitCommon;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QueueRabbitConfig
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Configuration
public class QueueRabbitConfig {
    @Bean
    public Queue queue(){
        return new Queue(RabbitCommon.QUEUE_ZERO);
    }
}
