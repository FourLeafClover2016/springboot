package com.hwx.tools;

import com.hwx.dao.LockedUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 已锁定用户管理
 *
 * @author: Huawei Xie
 * @date: 2019/5/31
 */
@Component
@Slf4j
public class UserLockedMemory {

    @Autowired
    private LockedUserMapper lockedUserMapper;

    /**
     * 内部存储被锁定的用户，key：用户名，value：被锁定时的时间
     */
    private static Map<String, Long> userLockedMemeoryMap = new HashMap<>();

    /**
     * 判断用户是否被锁定
     *
     * @param username 用户名
     * @return
     */
    public synchronized boolean isLocked(String username) {
        if (userLockedMemeoryMap.containsKey(username)) {
            return true;
        }
        return false;
    }

    /**
     * 解除用户锁定
     *
     * @param username
     */
    public synchronized void unlockUser(String username) {
        try {
            lockedUserMapper.deleteByUsername(username);
            if (userLockedMemeoryMap.containsKey(username)) {
                userLockedMemeoryMap.remove(username);
            }
        } catch (Exception e) {
            log.info("解锁用户失败");
        }
    }

    /**
     * 锁定用户
     *
     * @param username
     */
    public synchronized void lockUser(String username) {
        userLockedMemeoryMap.put(username, System.currentTimeMillis());
    }

    /**
     * 定时解除锁定的用户，每分钟执行一次
     */
    @Scheduled(initialDelay = 10000, fixedDelay = 60000)
    public synchronized void scheduledCleanLockedUser() {
        Iterator<Map.Entry<String, Long>> iterator = userLockedMemeoryMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> userLockedInfo = iterator.next();
            if (System.currentTimeMillis() - userLockedInfo.getValue() > 60000) {
                iterator.remove();
                try {
                    lockedUserMapper.deleteByUsername(userLockedInfo.getKey());
                } catch (Exception e) {
                    log.info("解锁用户失败");
                }

            }
        }

    }


}
