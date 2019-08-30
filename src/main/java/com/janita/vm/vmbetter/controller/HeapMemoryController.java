package com.janita.vm.vmbetter.controller;

import com.google.common.collect.Lists;
import com.janita.vm.vmbetter.dto.User;
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
     * -Xmx32M -Xms32M
     * java -jar -Xmx32M -Xms32M vm-better-0.0.1-SNAPSHOT.jar
     * @return
     */
    @GetMapping("/heap")
    public String heap() {
        while (true) {
            User user = new User(1, UUID.randomUUID().toString());
            userList.add(user);
        }
    }
}
