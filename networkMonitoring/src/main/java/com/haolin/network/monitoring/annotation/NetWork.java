package com.haolin.network.monitoring.annotation;

import com.haolin.network.monitoring.type.NetType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //该注解作用在方法之上
@Retention(RetentionPolicy.RUNTIME) //jvm运行时通过反射获取注解的值
public @interface NetWork {

    NetType netType() default NetType.AUTO;

}
