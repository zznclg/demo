package com.example.demo.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastjsonSockJsMessageCodec;
import com.example.demo.Interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configurable
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {

    /*
     *修改自定义消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //将fastJson添加到试图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }

   /* FastJson SerializerFeaturesWriteNullListAsEmpty ：List字段如果为null,输出为[],而非nullWriteNullStringAsEmpty ：
    字符类型字段如果为null,输出为"",而非nullDisableCircularReferenceDetect ：
    消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）WriteNullBooleanAsFalse：
    Boolean字段如果为null,输出为false,而非nullWriteMapNullValue：是否输出值为null的字段,默认为false。*/

   //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns().excludePathPatterns();
    }

    //配置静态资源路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/demo/resources/**").addResourceLocations("classpath:/static/");
    }
}
