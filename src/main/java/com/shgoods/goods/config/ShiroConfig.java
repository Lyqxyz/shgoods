package com.shgoods.goods.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.shgoods.goods.realm.LoginRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Value("#{ @environment['shiro.loginUrl'] ?: '/login' }")
    protected String loginUrl;
    @Value("#{ @environment['shiro.successUrl'] ?: '/index' }")
    protected String successUrl;
    @Value("#{ @environment['shiro.unauthorizedUrl'] ?: null }")
    protected String unauthorizedUrl;

    @Bean
    public LoginRealm loginRealm(){


        LoginRealm loginRealm = new LoginRealm();

        loginRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return loginRealm;
    }

    /**
     * 配置权限
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        filterFactoryBean.setSecurityManager(defaultWebSecurityManager());

        Map<String,String> definition = new LinkedHashMap<>();

        /**
         * 静态文件过滤
         */
        definition.put("/css/**","anon");
        definition.put("/js/**","anon");
        definition.put("/images/**","anon");
        definition.put("/fonts/**","anon");
        definition.put("/favicon.ico","anon");
        definition.put("/upload/**","anon");


        /**
         * 登录
         */
        definition.put("/login","anon");
        definition.put("/check","anon");



        /**
         * 注册
         */
        definition.put("/reg","anon");
        definition.put("/registered","anon");

        /**
         * sql监控
         */
        definition.put("/druid/*","authc");

        /**
         *  所有api
         * 后期完成权限控制
         */
        definition.put("/user/**","anon");

        definition.put("/college/**","anon");






        definition.put("/logout","logout");

        definition.put("/**","authc");

        filterFactoryBean.setFilterChainDefinitionMap(definition);

        filterFactoryBean.setLoginUrl(loginUrl);

        filterFactoryBean.setSuccessUrl(successUrl);

        filterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
        return filterFactoryBean;
    }
    @Bean("securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(){



        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

       //securityManager.setAuthenticator(modularRealmAuthenticator());

        securityManager.setRealm(loginRealm());

        //securityManager.setSessionManager(defaultWebSessionManager());

        return securityManager;

    }

//    @Bean
//    public DefaultWebSessionManager defaultWebSessionManager(){
//
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//
//        return  sessionManager;
//
//    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

//    @Bean
//    public ModularRealmAuthenticator modularRealmAuthenticator(){
//
//        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
//
//        authenticator.setAuthenticationStrategy(firstSuccessfulStrategy());
//
//        return authenticator;
//    }

    @Bean
    public AtLeastOneSuccessfulStrategy atLeastOneSuccessfulStrategy() {
        return new AtLeastOneSuccessfulStrategy();
    }
    @Bean
    public FirstSuccessfulStrategy firstSuccessfulStrategy(){
        return new FirstSuccessfulStrategy();
    }
    @Bean
    public AllSuccessfulStrategy allSuccessfulStrategy(){
        return new AllSuccessfulStrategy();
    }
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(20);
        return matcher;
    }

}
