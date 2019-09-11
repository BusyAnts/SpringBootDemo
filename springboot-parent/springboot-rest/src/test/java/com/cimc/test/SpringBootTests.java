package com.cimc.test;

import com.cimc.RestApplication;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenz
 * @create 2019-09-10 16:48
 */
@SpringBootTest(classes = RestApplication.class)
@RunWith(SpringRunner.class)
public class SpringBootTests {
    @Before
    public void testBefore() {
        System.out.println("before");
    }

    @Test
    public void testOne() {
        System.out.println("testOne");
        TestCase.assertEquals(1, 1);

    }

    @After
    public void testAfter() {
        System.out.println("after");
    }
}
