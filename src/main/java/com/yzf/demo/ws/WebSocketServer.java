package com.yzf.demo.ws;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * WebSocketServer
 *
 * @author Administrator
 * @date 2019/12/7
 */
@ServerEndpoint("/websocket/{uid}")
@Component
public class WebSocketServer {

    static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private static ConcurrentHashMap<String, Session> us = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Session, String> su = new ConcurrentHashMap<>();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        us.put(uid, session);
        su.put(session, uid);
        logger.info("有新窗口开始监听:" + uid + ",当前在线人数为" + us.size());

        try {
            sendMessage(session, "连接成功");
        } catch (IOException e) {
            logger.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        String uid = su.get(session);
        us.remove(uid);
        su.remove(session);
        logger.info("有一连接关闭！当前在线人数为" + us.size());
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        logger.info("收到来自窗口" + su.get(session) + "的信息:" + message);
        for (Session session1 : us.values()) {
            if (!session1.equals(session)) {
                session1.getBasicRemote().sendText(message);
            }
        }
    }

    /**
     * 异常关闭
     */
    @OnError
    public void onError(Session session, Throwable error) {
        String uid = su.get(session);
        us.remove(uid);
        su.remove(session);
        logger.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(Session session, String message) throws IOException {
        if (session == null) {
            logger.error("websocket IO异常");
            return;
        }
        session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("uid") String uid) throws IOException {
        logger.info("推送消息到窗口" + uid + "，推送内容:" + message);
        //这里可以设定只推送给这个sid的，为null则全部推送
        if (uid == null) {
            for (Session session : us.values()) {
                if (session != null) {
                    session.getBasicRemote().sendText(message);
                }
            }
        } else {
            Session session = us.get(uid);
            if (session != null) {
                session.getBasicRemote().sendText(message==null?"NULL":message);
            }
        }

    }

}
