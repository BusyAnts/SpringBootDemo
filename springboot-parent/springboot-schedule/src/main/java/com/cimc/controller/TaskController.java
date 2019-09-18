package com.cimc.controller;

import com.cimc.task.AsyncTask;
import com.cimc.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author chenz
 * @create 2019-09-18 10:38
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private AsyncTask task;

    @GetMapping("asyncTask")
    public JsonData asyncTask() throws InterruptedException {
        long begin = System.currentTimeMillis();
        task.task1();
        task.task2();
        task.task3();
        long end = System.currentTimeMillis();
        long total = end-begin;
        System.out.println("执行总耗时="+total);
        return JsonData.buildSuccess(total);
    }

    @GetMapping("asyncTaskResult")
    public JsonData asyncTaskResult() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Future<String> task4 = task.task4();
        Future<String> task5 = task.task5();
        Future<String> task6 = task.task6();
        for(;;){
            if (task4.isDone() && task5.isDone() && task6.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        long total = end-begin;
        System.out.println("执行总耗时="+total);
        return JsonData.buildSuccess(total);
    }

}
