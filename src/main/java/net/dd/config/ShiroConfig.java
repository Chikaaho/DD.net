package net.dd.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import net.dd.config.shiro.StudentRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 凭证匹配器
     * 密码校验交给Shiro的SimpleAuthenticationInfo进行处理
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数;
        //true:hex  false:base64
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false);
        return hashedCredentialsMatcher;
    }



    //shiroFilerFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getshiroFilerFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有 记住我 功能才能用
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
        */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权,正常的情况下，没有授权会跳转到未授权页面
//        filterMap.put("/user/add","perms[0]");
//        filterMap.put("/user/update","perms[1]");
//
//
//        filterMap.put("/**","authc");
//        bean.setFilterChainDefinitionMap(filterMap);
//
//
//        //设置登录的请求
//        //bean.setLoginUrl("/toLogin");
//        //未授权的请求（页面）
//        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //DefaultWebSecurityMannager：2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("StudentRealm") StudentRealm StudentRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联StudentRealm
        securityManager.setRealm(StudentRealm);
        return securityManager;
    }

    //创建realm对象，需要自定义类：1
    @Bean
    public StudentRealm StudentRealm(){
        StudentRealm a = new StudentRealm();
        a.setCredentialsMatcher(hashedCredentialsMatcher());
        return a;
    };

    //整合ShiroDialect：用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
