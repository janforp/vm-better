package com.janita.vm.vmbetter.controller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类说明：
 *
 * @author zhucj
 * @since 2019-08-30 - 22:30
 */
@RestController
public class MetaSpaceOOMController {

    private List<Class> classList = Lists.newArrayList();

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     *
     * java -jar -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=60M vm-better-0.0.1-SNAPSHOT.jar
     * @return
     */
    @GetMapping("/metaSpace")
    public String metaSpace() {
        while (true) {
            classList.add(String.class);
        }
    }
}
