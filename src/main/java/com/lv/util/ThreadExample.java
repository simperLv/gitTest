package com.lv.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simperLv
 * on 2018/08/21 17:43
 *
 * @Description //TODO
 */
public class ThreadExample {
    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }
    public synchronized void after(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadExample example = new ThreadExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }
}
