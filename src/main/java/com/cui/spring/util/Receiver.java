package com.cui.spring.util;

/**
 * Created by cjs
 * Date： 2017/7/20.
 * Time： 11:25.
 */
import java.util.concurrent.CountDownLatch;

import com.cui.spring.web.control.UserTall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.jta.UserTransactionAdapter;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();
    }
}
