package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 该代码跟业务毫无关系
 *
 * @author janita
 */
@BTrace
public class PrintArgSimple {

    /**
     * <p>使用方法： 1.btrace PID PrintArgSimple.java</p>
     * <p>使用方法： 2.正常调用方法即可看的btrace终端的输出</p>
     * 拦截
     *
     * @param pcn  类名
     * @param pmn  方法名称
     * @param args 任何类型
     */
    @OnMethod(
        //拦截的类
        clazz = "com.janita.vm.vmbetter.controller.BtraceController",
        //拦截的方法
        method = "helloName",
        // 拦截的地方
        location = @Location(Kind.ENTRY))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.printArray(args);
        BTraceUtils.println("类名称 ：" + pcn);
        BTraceUtils.println("方法名称 ：" + pmn);
        BTraceUtils.println();
    }
}
