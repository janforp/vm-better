package com.janita.vm.vmbetter.controller.btrace;

import com.janita.vm.vmbetter.dto.User;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

import java.lang.reflect.Field;

/**
 * 该代码跟业务毫无关系
 *
 * @author janita
 */
@BTrace
public class PrintArgComplex {

    /**
     * @param user 拦截该方法的入参数
     */
    @OnMethod(
        //类
        clazz = "com.janita.vm.vmbetter.controller.BtraceController",
        //方法
        method = "updateUser",
        //时机
        location = @Location(Kind.ENTRY))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
        //print all fields
        BTraceUtils.printFields(user);
        //print one field
        Field filed2 = BTraceUtils.field("com.janita.vm.vmbetter.dto.User", "name");
        //打印某个参数
        BTraceUtils.println("user对象的name = " + BTraceUtils.get(filed2, user));
        BTraceUtils.println("类名称 ：" + pcn);
        BTraceUtils.println("方法名称 ：" + pmn);
        BTraceUtils.println();
    }
}
