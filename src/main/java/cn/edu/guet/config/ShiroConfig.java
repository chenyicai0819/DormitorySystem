package cn.edu.guet.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author George
 * @project shirodemo
 * @package com.example.shirodemo.config
 * @date 2021/7/26 21:35
 * @since 1.0
 */
@Configuration
public class ShiroConfig {
  /**
   * 创建ShiroFilterFactoryBean
   */
  @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    //设置安全管理器
    shiroFilterFactoryBean.setSecurityManager(securityManager);

    //添加Shiro内置过滤器
    /**
     * Shiro内置过滤器，可以实现权限相关的拦截器
     * 常用的有：
     * 	anon：无需认证就能访问
     authc：必须认证才能访问
     user：必须拥有 “记住我” 功能才能使用
     perms：拥有对某个资源的权限才能访问
     role： 拥有对某个角色权限才能访问
     */
    LinkedHashMap<String, String> filterMap = new LinkedHashMap<String,String>();
//		filterMap.put("/add", "authc");
//		filterMap.put("/update", "authc");
    //放行的用户放在前面
    filterMap.put("/toLogin", "anon");
    filterMap.put("/login", "anon");
    filterMap.put("/updatePassword", "anon");
    filterMap.put("/toUpdatePassword", "anon");
    filterMap.put("/*", "authc");

    //修改登录页面
    shiroFilterFactoryBean.setLoginUrl("/toLogin");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

    return shiroFilterFactoryBean;
  }

  /**
   * 创建DefaultWebSecurityManager
   */
  @Bean(name="securityManager")
  public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("MyRealm") MyRealm myRealm) {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //关联Realm
    securityManager.setRealm(myRealm);
    return securityManager;
  }

  /**
   * 创建Realm对象（第一步）
   * @Bean 将方法返回的对象放入Sprin环境进行管理
   */
  @Bean(name="MyRealm")
  public MyRealm myRealm() {
    return new MyRealm();
  }
}
