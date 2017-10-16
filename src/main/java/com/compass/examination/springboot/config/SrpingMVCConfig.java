package com.compass.examination.springboot.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.compass.examination.component.date.JsonDateMutualComponent;
import com.compass.examination.component.interceptor.UserLoginHandlerInterceptor;

/**
 * 
 * <p>Class Name: SrpingMVCConfig</p>
 * <p>Description: Spring MVC 配置</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月15日下午11:38:14
 * @version 2.0
 */
@SpringBootConfiguration
public class SrpingMVCConfig extends WebMvcConfigurerAdapter{ // 继承父类，重写方法，添加拦截器
	
	@Autowired
	private UserLoginHandlerInterceptor userLoginHandlerInterceptor;
	/**
     * （非 Javadoc）
     * Method Name: addInterceptors
     * Description: 自定义拦截器
     * @author wkm
     * @date 2017年10月16日上午12:30:17
     * @version 2.0
     * @param registry
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// 判断用户是否登录拦截器
    	registry.addInterceptor(userLoginHandlerInterceptor).addPathPatterns("/xxx/**");
    
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
                System.out.println("自定义拦截器............");
                return true;
            }
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    ModelAndView modelAndView) throws Exception {
            }
            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                    Exception ex) throws Exception {
            }
        };
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }*/
	
	/**
	 * 
	 * <p>Method Name: mappingJackson2HttpMessageConverter</p>
	 * <p>Description: 自定义JSON日期转换组件</p>
	 * @author wkm
	 * @date 2017年10月16日上午12:28:01
	 * @version 2.0
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean // 仅在当前上下文中不存在实例对象时，实例化Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(
			JsonDateMutualComponent jsonDateMutualComponent) { // spring IOC
		MappingJackson2HttpMessageConverter converter = 
				new MappingJackson2HttpMessageConverter(jsonDateMutualComponent.getMapper());
		return converter;
	}

    // 自定义消息转化器: 方法一, springboot 默认的编码是UTF-8, 可不配置
    /*@Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }*/
    
    // 自定义消息转化器: 方法二, springboot 默认的编码是UTF-8, 可不配置
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter  = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(converter);
    }*/
}
