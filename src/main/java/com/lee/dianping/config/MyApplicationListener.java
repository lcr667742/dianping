package com.lee.dianping.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 自定义应用监听器
 */
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Log logger = LogFactory.getLog(MyApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("------------------------> MyApplicationListener");
    }
}
