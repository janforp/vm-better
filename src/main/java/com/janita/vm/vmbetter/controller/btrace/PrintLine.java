package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 拦截执行代码的行号码
 *
 * @author janita
 */
@BTrace
public class PrintLine {

    /**
     * 拦截行
     *
     * @param pcn  类
     * @param pmn  方法
     * @param line 行
     */
    @OnMethod(
        //拦截的类
        clazz = "com.janita.vm.vmbetter.controller.BtraceController",
        //方法
        method = "exception",
        //拦截的地方/类型，在此为行，如果此值为-1，则打印出每行被执行的代码，否则就值打印该行
        location = @Location(value = Kind.LINE, line = -1))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
        BTraceUtils.println(pcn + "," + pmn + "," + line);
        BTraceUtils.println("执行的行 ：" + line);
        BTraceUtils.println();
    }
}
