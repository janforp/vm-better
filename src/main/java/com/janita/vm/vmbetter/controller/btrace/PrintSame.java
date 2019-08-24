package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 拦截同名称的方法
 *
 * @author janita
 */
@BTrace
public class PrintSame {

    @OnMethod(
        //拦截的类
        clazz = "com.janita.vm.vmbetter.controller.BtraceController",
        //方法名称
        method = "same")
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, String name) {
        BTraceUtils.println(pcn + "," + pmn + "," + name);
        BTraceUtils.println();
    }
}
