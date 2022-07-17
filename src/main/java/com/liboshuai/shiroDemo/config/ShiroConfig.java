package com.liboshuai.shiroDemo.config;

import com.liboshuai.shiroDemo.shiro.UserRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mapstruct.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: liboshuai
 * @Date: 2022-07-16 08:31
 * @Description: shiro配置类
 */
@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean(value = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 路径过滤规则
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        Map<String, String> map = new LinkedHashMap<>();
        // 有先后顺序
        map.put("/login/userLogin", "anon"); // 允许匿名访问
        // 允许swagger
        map.put("/swagger-ui.html","anon");
        map.put("/doc.html","anon");
        map.put("/webjars/**","anon");
        map.put("/swagger-resources","anon");
        map.put("/v2/api-docs","anon");
        map.put("/swagger-resources/**","anon");
        map.put("/**", "authc"); // 进行身份认证后才能访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
