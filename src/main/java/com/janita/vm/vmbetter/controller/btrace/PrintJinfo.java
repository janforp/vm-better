package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;

/**
 * 拦截异常
 *
 * @author janita
 */
@BTrace
public class PrintJinfo {

    //类似jinfo命令
    static {
        BTraceUtils.println("System Properties:");
        BTraceUtils.printProperties();
        BTraceUtils.println("VM Flags:");
        BTraceUtils.printVmArguments();
        BTraceUtils.println("OS Enviroment:");
        BTraceUtils.printEnv();
        BTraceUtils.exit(0);
    }
}