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

    @GetMapping("/metaSpace")
    public String metaSpace() {
        while (true) {
            classList.add(String.class);
        }
    }
}
