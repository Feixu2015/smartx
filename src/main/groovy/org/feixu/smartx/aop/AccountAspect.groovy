/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.aop

import com.alibaba.fastjson.JSONObject
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
/**
 * 账户切面
 *
 * @author Feixu
 * @version $Id: AccountAspect.java, v 0.1 2018/7/5 Feixu Exp $
 */
@Aspect
class AccountAspect {

    @Pointcut("execution(public boolean withdraw(int))")
    void checkAccount() {
        println "I am pointcut"
    }

    /*@Around("checkAccount()")
    Object doSomeThing(ProceedingJoinPoint pjp) throws Throwable {
        println "around: ${JSONObject.toJSONString(pjp, true)}"
        return null
    }*/

    @After("checkAccount()")
    void checkAfterAccount(JoinPoint joinPoint) {
        println "after: ${JSONObject.toJSONString(joinPoint, true)}"
    }

    @Before("checkAccout()")
    void checkBeforeAccount(JoinPoint joinPoint) {
        println "before: ${JSONObject.toJSONString(joinPoint, true)}"
    }
}
