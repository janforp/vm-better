package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 拦截构造器
 *
 * @author janita
 */
@BTrace
public class PrintConstructor {

    @OnMethod(
        //拦截的类
        clazz = "com.janita.vm.vmbetter.dto.User",
        //拦截构造器
        method = "<init>")
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println();
    }
}
