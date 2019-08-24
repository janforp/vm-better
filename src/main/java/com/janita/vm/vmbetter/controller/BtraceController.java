package com.janita.vm.vmbetter.controller;

import com.janita.vm.vmbetter.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明：
 *
 * @author zhucj
 * @since 2019-08-24 - 14:45
 */
@RestController
@RequestMapping("/btrace")
public class BtraceController {

    @GetMapping("/arg1")
    public String helloName(@RequestParam("name") String name) {
        return "hello," + name;
    }

    @GetMapping("/arg2")
    public User updateUser(User user) {
        return user;
    }

    @GetMapping("/constructor")
    public User constructor(User user) {
        return user;
    }

    @GetMapping("/same1")
    public String same(@RequestParam("name") String name) {
        return "hello," + name;
    }

    @GetMapping("/same2")
    public String same(@RequestParam("name") String name, @RequestParam("id") int id) {
        return "hello," + name + "," + id;
    }

    @GetMapping("/exception")
    public String exception() {
        try {
            System.out.println("start...");
            System.out.println(1 / 0);
            System.out.println("end...");
        } catch (Exception e) {
            //使用btrace就可以重新这个被忽略的堆栈
        }
        return "success";
    }
}
