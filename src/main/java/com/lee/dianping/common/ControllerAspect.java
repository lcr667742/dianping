package com.lee.dianping.common;

import com.lee.dianping.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description 控制层切面
 * @Author 61671
 * @Date 2022/8/26 14:53
 * @Version 1.0.0
 */
@Aspect
@Configuration
public class ControllerAspect {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private HttpServletResponse httpServletResponse;

    /**
     * 通知增强处理
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.lee.dianping.controller.admin.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);

        if(adminPermission == null){
            //公共方法直接返回
            return joinPoint.proceed();
        }

        //获取会话标识
        String email = (String) this.httpServletRequest.getSession().getAttribute(AdminController.CURRENT_ADMIN_SESSION);
        if(email == null){
            if("text/html".equals(adminPermission.produceType())){
                httpServletResponse.sendRedirect("/admin/admin/loginPage");
                return null;
            } else {
                CommonError commonError= new CommonError(EmBusinessError.ADMIN_SHOULD_LOGIN);
                return CommonRes.create(commonError,"fail");
            }
        }

        return joinPoint.proceed();
    }

}
