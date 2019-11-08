package com.cimc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenz
 * @create 2019-11-08 17:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoadDataApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private int num = 0;
    private int end = 0;
    private Long start = 0L;
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(200));

    @Test
    public void testLoadData() {
        Long start = System.currentTimeMillis();
        File folder = new File("D:/data");
        File[] files = folder.listFiles();
        for (File file : files) {
            String sql = "LOAD DATA LOCAL INFILE 'D:/data/" + file.getName() + "'" + " IGNORE INTO TABLE t_test " +
                    "character set 'utf8' fields terminated by ',' optionally enclosed by '\"' " +
                    "lines terminated by '\n' (id,name)";
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        }
        Long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
    }

    @Test
    public void testLoadData2() {
        start = System.currentTimeMillis();
        File folder = new File("D:/data");
        File[] files = folder.listFiles();
        for (File file : files) {
            end = files.length;
            Task task = new Task(jdbcTemplate, file);
            pool.execute(task);
        }
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateNum() {
        num++;
        if (num == end) {
            pool.shutdown();
            System.out.println("执行结束");
            Long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000);
        }
    }

    class Task implements Runnable {
        private JdbcTemplate jdbcTemplate;
        private File file;

        public Task(JdbcTemplate jdbcTemplate, File file) {
            this.jdbcTemplate = jdbcTemplate;
            this.file = file;
        }

        @Override
        public void run() {
            String sql = "LOAD DATA LOCAL INFILE 'D:/data/" + file.getName() + "'" + " IGNORE INTO TABLE t_test " +
                    "character set 'utf8' fields terminated by ',' optionally enclosed by '\"' " +
                    "lines terminated by '\n' (id,name)";
            System.out.println(sql);
            jdbcTemplate.execute(sql);
            updateNum();
        }
    }

}

