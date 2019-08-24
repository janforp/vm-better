package com.janita.vm.vmbetter.controller.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Return;

/**
 * 拦截返回值
 *
 * @author janita
 */
@BTrace
public class PrintReturn {

    @OnMethod(clazz = "com.janita.vm.vmbetter.controller.BtraceController",
              //拦截的方法名称
              method = "helloName",
              //拦截返回值
              location = @Location(Kind.RETURN))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn,
        //必须加该注解，才表示是返回值
        @Return AnyType result) {
        BTraceUtils.println(pcn + "," + pmn + "," + result);
        BTraceUtils.println();
    }
}
