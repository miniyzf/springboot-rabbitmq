package com.yzf.demo.rabbitmq.fanout;

import com.yzf.demo.rabbitmq.MQConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FanoutRabbitConfig
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Configuration
public class FanoutRabbitConfig {
    /**
     * 声明队列
     * @return
     */
    @Bean
    public Queue fanoutQueueOne(){
        return new Queue(MQConst.FANOUT_QUEUE_ONE);
    }
    @Bean
    public Queue fanoutQueueTwo(){
        return new Queue(MQConst.FANOUT_QUEUE_TWO);
    }
    @Bean
    public Queue fanoutQueueThree(){
        return new Queue(MQConst.FANOUT_QUEUE_THREE);
    }

    /**
     * 声明交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(MQConst.FANOUT_EXCHANGE);
    }

    /**
     * 绑定队列到交换机
     * fanoutQueueOne 必须与声明队列方法名 fanoutQueueOne 相同
     */
    @Bean
    public Binding fanoutBindingQueueOneToExchange(Queue fanoutQueueOne,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueOne).to(fanoutExchange);
    }
    @Bean
    public Binding fanoutBindingQueueTwoToExchange(Queue fanoutQueueTwo,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueTwo).to(fanoutExchange);
    }
    @Bean
    public Binding fanoutBindingQueueThreeToExchange(Queue fanoutQueueThree,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueThree).to(fanoutExchange);
    }
}
