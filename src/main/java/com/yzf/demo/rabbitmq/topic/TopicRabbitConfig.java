package com.yzf.demo.rabbitmq.topic;

import com.yzf.demo.rabbitmq.RabbitCommon;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TopicRabbitConfig
 *
 * @author Administrator
 * @date 2019/12/5
 */
@Configuration
public class TopicRabbitConfig {



    @Bean
    public Queue queueOne(){
        return new Queue(RabbitCommon.TOPIC_QUEUE_ONE);
    }
    @Bean
    public Queue queueTwo(){
        return new Queue(RabbitCommon.TOPIC_QUEUE_TWO);
    }

    /**
     * 声明 topic 类型交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(RabbitCommon.TOPIC_EXCHANGE);
    }

    /**
     * 绑定队列到交换机，并指定routingKey
     * @param queueOne
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding queueBindTopicExchangeOne(Queue queueOne,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueOne).to(topicExchange).with(RabbitCommon.TOPIC_BINDING_KEY_ONE);
    }
    @Bean
    public Binding queueBindTopicExchangeTwo(Queue queueTwo,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTwo).to(topicExchange).with(RabbitCommon.TOPIC_BINDING_KEY_TWO);
    }
}
