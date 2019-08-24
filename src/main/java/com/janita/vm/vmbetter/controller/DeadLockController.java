package com.janita.vm.vmbetter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明：
 * <p>使用 jstack </p>
 * <info>死锁.txt</info>
 * @author zhucj
 * @since 2019-08-24 - 13:32
 */
@RestController
@RequestMapping("/lock")
public class DeadLockController {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    /**
     * 死锁
     */
    @GetMapping("/deadlock")
    public String deadlock() {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }
                synchronized (lock2) {
                    System.out.println("Thread1 over");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }
                synchronized (lock1) {
                    System.out.println("Thread2 over");
                }
            }
        }).start();
        return "deadlock";
    }
}
