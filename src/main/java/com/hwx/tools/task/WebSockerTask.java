package com.hwx.tools.task;

import com.hwx.config.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * websocket 定时任务
 */
@Component
public class WebSockerTask {
    @Autowired
    private WebSocketServer webSocketServer;

    @Scheduled(fixedRate = 3000L)
    public void task1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        webSocketServer.sendInfo("current time:" + simpleDateFormat.format(date));

    }
}
