package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 该代码跟业务毫无关系
 *
 * @author janita
 */
@BTrace
public class PrintRegex {

    @OnMethod(
        //类
        clazz = "com.janita.vm.vmbetter.controller.BtraceController",
        //以正则的方式拦截方法，此写法就是拦截所有方法
        method = "/.*/")
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn) {
        BTraceUtils.println("类名称 ：" + pcn);
        BTraceUtils.println("方法名称 ：" + pmn);
        BTraceUtils.println();
    }
}
