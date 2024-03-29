package com.janita.vm.vmbetter.controller;

import com.google.common.collect.Lists;
import com.janita.vm.vmbetter.dto.User;
import com.janita.vm.vmbetter.dto.UserChild;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * 类说明：
 *
 * @author zhucj
 * @since 2019-08-30 - 22:12
 */
@RestController
public class HeapMemoryController {

    private List<User> userList = Lists.newArrayList();

    /**
     * -Xmx32M -Xms32M java -jar -Xmx32M -Xms32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./ vm-better-0.0.1-SNAPSHOT.jar
     */
    @GetMapping("/heap")
    public String heap() {
        while (true) {
            System.out.println("*****创建对象");
            User user = new User(1, UUID.randomUUID().toString(), get());
            userList.add(user);
        }
    }

    private static UserChild get() {
        UserChild userChild = new UserChild();
        userChild.setChildAge((int) Math.random());
        userChild.setChildName("张三的儿子" + Math.random());
        return userChild;
    }
}
