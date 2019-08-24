package com.janita.vm.vmbetter.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.janita.vm.vmbetter.utils.ShowUtils.getPartneridsFromJson;

/**
 * 类说明：
 * <info>调优日志信息/死循环-cpu高时候的jstack信息.txt</info>
 * <P>线上cpu负荷超高的时候的排查非法</P>
 * <p>1.top 目录，找出进程号</p>
 * <p>2.jstack pic > 目标文件</p>
 * <p>3.top -p pid -H 查看该进程下的cpu使用率情况，按cpu从高到低的线程排序，找到排名第一的线程id <intent>为16进制的，使用  printf "%x" 8247 转换为十进制</intent></p>
 * <p>4.拿到该十进制线程id去上面的文件中查询，查看堆栈信息</p>
 *
 * @author zhucj
 * @since 2019-08-24 - 12:48
 */
@RestController
public class CpuController {

    @GetMapping("/loop")
    public List<Long> loop(String data) {
        if (StringUtils.isEmpty(data)) {
            data = "{\"data\":[{\"partnerid\":]";
        }
        return getPartneridsFromJson(data);
    }
}
