package com.yzf.demo;

import com.yzf.demo.rabbitmq.MQConst;
import com.yzf.demo.rabbitmq.fanout.FanoutProducer;
import com.yzf.demo.rabbitmq.ptoc.QueueRabbitProducer;
import com.yzf.demo.rabbitmq.topic.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TopicExchangeTests
 *
 * @author Administrator
 * @date 2019/12/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicExchangeTests {

    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void sendTopicRoutingKeyOne(){
        String message = "send to topic.message";
        topicProducer.sendRoutingKeyOne(message);
    }

    @Test
    public void sendTopicRoutingKeyTwo(){
        String message = "send to topic.msg";
        topicProducer.sendRoutingKeyTwo(message);
    }


    @Autowired
    private FanoutProducer fanoutProducer;

    @Test
    public void sendFanout(){
        String message = "send to fanout exchange";
        fanoutProducer.sendFanout(message);
    }

/*
    // 简单模式：一个 queue 一个或多个 consumer ，@Test 测试时多出一个 consumer 监听；接口测试OK
    @Autowired
    private QueueRabbitProducer queueRabbitProducer;
    @Test
    public void sendQueue1(){
        String message = "send to queue one";
        queueRabbitProducer.sendQueue(message);
    }
    @Test
    public void sendQueue2() throws InterruptedException {
        String message = "send to queue two";
        for (int i = 0; i < 10; i++) {
            queueRabbitProducer.sendQueue(message + i);
            Thread.sleep(100);
        }
    }*/
}
