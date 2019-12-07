package com.yzf.demo.rabbitmq;

/**
 * RabbitConfig
 *
 * @author Administrator
 * @date 2019/12/5
 */
public class MQConst {

    /**
     * 简单
     */
    public final static String QUEUE_ZERO = "queue_zero";

    /**
     * exchange types topic
     */
    public final static String TOPIC_EXCHANGE = "topic_exchange_name";
    public final static String TOPIC_QUEUE_ONE = "topic_queue_one";
    public final static String TOPIC_QUEUE_TWO = "topic_queue_two";
    public final static String TOPIC_BINDING_KEY_ONE = "topic.message";
    public final static String TOPIC_BINDING_KEY_TWO = "topic.#";
    public final static String TOPIC_ROUTING_KEY_ONE = "topic.message";
    public final static String TOPIC_ROUTING_KEY_TWO = "topic.msg";

    /**
     * exchange types fanout
     */
    public final static String FANOUT_EXCHANGE = "fanout_exchange_name";
    public final static String FANOUT_QUEUE_ONE = "fanout_queue_one";
    public final static String FANOUT_QUEUE_TWO = "fanout_queue_two";
    public final static String FANOUT_QUEUE_THREE = "fanout_queue_three";
}
