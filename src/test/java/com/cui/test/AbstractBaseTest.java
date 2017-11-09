
package com.cui.test;

import com.cui.spring.Application;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by zhangxiaohang5 on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class AbstractBaseTest {
    protected static Logger logger = LoggerFactory.getLogger(AbstractBaseTest.class);
}

