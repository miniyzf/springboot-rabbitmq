package com.yzf.demo.rabbitmq;

import com.yzf.demo.rabbitmq.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

/**
 * MQController
 *
 * @author Administrator
 * @date 2019/12/12
 */
@Controller
public class MQController {
    @GetMapping("/mq")
    public ModelAndView goMq(){
        ModelAndView mav = new ModelAndView("mq");
        return mav;
    }

    @Autowired
    private TopicProducer topicProducer;

    @RequestMapping("/exchange/topic")
    public @ResponseBody String sendTopicMessage(@PathParam("message")String message){
        topicProducer.sendRoutingKeyOne(message);
        return message;
    }

    @RequestMapping("/exchange/topic2")
    public @ResponseBody String sendTopicMsg(@PathParam("msg")String msg){
        topicProducer.sendRoutingKeyTwo(msg);
        return msg;
    }
}
