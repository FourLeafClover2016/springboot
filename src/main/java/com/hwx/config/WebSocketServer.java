package com.hwx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * websocket
 */
@Slf4j
@Component
@ServerEndpoint("/websocket")
public class WebSocketServer {
    // 静态变量,用来记录当前在线连接数,
    private static int onlineCount = 0;
    // Concurrent包的线程安全set,用于存放每个客户端的websocket对象
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();

    private Session session;

    /**
     * 连接成功调用方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketServers.add(this);
        addOnloneCount();
        log.info("新连接加入,当前连接数:" + getOnlineCount());
        try {
            sendMessage("ok");
        } catch (IOException e) {
            log.error("websocket error");
        }
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose() {
        webSocketServers.remove(this);
        subOnlineCount();
        log.info("有连接关闭,当前连接数:{}", getOnlineCount());
    }

    /**
     * 接收客户端消息后用方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("client messge:{}", message);

    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("happen error");
        error.printStackTrace();
    }

    /**
     * 发送消息
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发消息
     */
    public void sendInfo(String message) {
        log.info("向客户端推送消息");
        for (WebSocketServer item : webSocketServers) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnloneCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }


}
