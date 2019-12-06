package com.yzf.demo.rabbitmq.ptoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * QueueProducerController
 *
 * @author Administrator
 * @date 2019/12/6
 */
@Controller
@RequestMapping("queue")
public class QueueProducerController {
    @Autowired
    private QueueRabbitProducer queueRabbitProducer;

    @RequestMapping("send")
    public @ResponseBody String
    sendQueue(@RequestParam("msg") String msg){
        queueRabbitProducer.sendQueue(msg);
        return msg;
    }
}
