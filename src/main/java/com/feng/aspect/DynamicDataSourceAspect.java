package com.feng.aspect;

import com.feng.annotation.DS;
import com.feng.util.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/6/2
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(com.feng.annotation.DS)")
    public void beforeSwitchDs(JoinPoint point){
        Class<?> className = point.getTarget().getClass();
        String methodName = point.getSignature().getName();

        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();

        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            Method method = className.getMethod(methodName, argClass);
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("@annotation(com.feng.annotation.DS)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }

}
