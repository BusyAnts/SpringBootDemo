package com.cimc.task;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenz
 * @create 2019-09-17 16:41
 */
@Component
public class MyTask {

    private AtomicInteger number = new AtomicInteger();

    //@Scheduled(cron = "0/5 * * * * *")
    public void work() {
        System.out.println("结束 当前时间:" + new Date());
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        return taskScheduler;
    }

    //@Scheduled(fixedRate = 5000)
    //@Scheduled(fixedDelay = 5000)
    public void job() {
        LocalTime start = LocalTime.now();
        System.out.println(Thread.currentThread() + " start " + number.incrementAndGet() + " @ " + start);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(15) * 1000);
        } catch (InterruptedException e) {
        }
        LocalTime end = LocalTime.now();
        System.out.println(Thread.currentThread() + " end " + number.get() + " @ " + end
                + ", seconds cost " + (ChronoUnit.SECONDS.between(start, end)));
    }

    private AtomicBoolean firstTime = new AtomicBoolean(true);

    //@Scheduled(fixedRate = 5000)
    public void job2() {
        LocalTime start = LocalTime.now();
        System.out.println(Thread.currentThread() + " start " + number.incrementAndGet() + " @ " + start);
        if (firstTime.getAndSet(false)) {
            try {
                Thread.sleep(23000);
            } catch (InterruptedException e) {
            }
        }
        LocalTime end = LocalTime.now();
        System.out.println(Thread.currentThread() + " end " + number.get() + " @ " + end
                + ", seconds cost " + (ChronoUnit.SECONDS.between(start, end)));
    }

}
