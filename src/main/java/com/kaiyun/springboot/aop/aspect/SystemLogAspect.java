/**
 * Project Name:springboot-aspectJ-aop
 * File Name:SystemLogAspect.java
 * Package Name:com.kaiyun.springboot.aop.aspect
 * Date:2019年3月26日上午11:16:14
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaiyun.springboot.aop.annotation.SystemControllerLog;
import com.kaiyun.springboot.aop.annotation.SystemServiceLog;
import com.kaiyun.springboot.aop.enums.AnnotationTypeEnum;
import com.kaiyun.springboot.aop.service.SystemLogStrategy;
import com.kaiyun.springboot.aop.utils.JsonUtil;
import com.kaiyun.springboot.aop.utils.ThreadUtil;

/**
 * ClassName:SystemLogAspect <br/>
 * Function: 定义切面. <br/>
 * Date:     2019年3月26日 上午11:16:14 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Aspect
public class SystemLogAspect {
	
    private static final Logger LOG = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("execution(* com.kaiyun..*(..)) && !execution(* com.kaiyun.springboot.aop.config..*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        Object result = null;

        try {
        	//通过反射执行目标对象的连接点处的方法
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            LOG.error(throwable.getMessage(), throwable);
            throw new RuntimeException(throwable);
        } finally {
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;

            printLog(pjp, result, elapsedTime);

        }

        return result;
    }

    /**
     * printLog:打印日志. <br/>
     *
     * @param pjp			连接点
     * @param result		方法调用返回结果
     * @param elapsedTime	方法调用花费时间
     * @since JDK 1.8
     * @author kaiyun
     */
    private void printLog(ProceedingJoinPoint pjp, Object result, long elapsedTime) {
        SystemLogStrategy strategy = getFocus(pjp);

        if (null != strategy) {
            strategy.setThreadId(ThreadUtil.getThreadId());
            strategy.setResult(JsonUtil.toJSONString(result));
            strategy.setElapsedTime(elapsedTime);
            if (strategy.isAsync()) {
                new Thread(()->LOG.info(strategy.format(), strategy.args())).start();
            }else {
                LOG.info(strategy.format(), strategy.args());
            }
        }
    }

    /**
     * getFocus:获取注解. <br/>
     *
     * @param pjp
     * @return
     * @since JDK 1.8
     * @author kaiyun
     */
    private SystemLogStrategy getFocus(ProceedingJoinPoint pjp) {
    	//获取连接点的方法签名对象
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        Object[] args = pjp.getArgs();
        String targetClassName = pjp.getTarget().getClass().getName();
        try {
            Class<?> clazz = Class.forName(targetClassName);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    if (args.length == method.getParameterCount()) {

                        SystemLogStrategy strategy = new SystemLogStrategy();
                        strategy.setClassName(className);
                        strategy.setMethodName(methodName);

                        SystemControllerLog systemControllerLog = method.getAnnotation(SystemControllerLog.class);
                        if (null != systemControllerLog) {
                            strategy.setArguments(JsonUtil.toJSONString(args));
                            strategy.setDescription(systemControllerLog.description());
                            strategy.setAsync(systemControllerLog.async());
                            strategy.setLocation(AnnotationTypeEnum.CONTROLLER.getName());
                            return strategy;
                        }
                        SystemServiceLog systemServiceLog = method.getAnnotation(SystemServiceLog.class);
                        if (null != systemServiceLog) {
                            strategy.setArguments(JsonUtil.toJSONString(args));
                            strategy.setDescription(systemServiceLog.description());
                            strategy.setAsync(systemServiceLog.async());
                            strategy.setLocation(AnnotationTypeEnum.SERVICE.getName());
                            return strategy;
                        }
                        
                        return null;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

}

