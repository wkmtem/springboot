package com.compass.examination.component.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Class Name: UserLoginHandlerInterceptor</p>
 * <p>Description: 用户登录拦截器</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月16日上午2:00:52
 * @version 2.0
 */
@Component
public class UserLoginHandlerInterceptor implements HandlerInterceptor {

    public static final String COOKIE_NAME = "TT_TOKEN";

    /*@Autowired
    private UserService userService;*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
    	String token = "";
        if (StringUtils.isEmpty(token)) {
            // 未登录状态
            return true;
        }
        //User user = this.userService.queryUserByToken(token);
        /*if (null == user) {
            return true;
        }*/
        //UserThreadLocal.set(user); // 将对象放入到本地线程中
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        //UserThreadLocal.set(null);
    }
}
