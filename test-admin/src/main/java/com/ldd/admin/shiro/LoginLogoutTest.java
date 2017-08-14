package com.ldd.admin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>功能描述：</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 刘大德</p>
 *
 * @author Mr.Liu
 * @version 1.0 2016/4/13 16:16
 */
public class LoginLogoutTest {

    @Test
    public void testHelloWorld(){
        //1、获取 SecurityManager 工厂，此处使用 Ini 配置文件初始化 SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:myRealm1.ini");
        //2、得到SecurityManager实例，并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("admin","66");
        String erro="";
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            erro="身份出错";
        }
        if ("".equals(erro)){
            erro="success";
        }

        if("success".equals(erro)){
            Assert.assertEquals(true,subject.isAuthenticated());
            subject.logout();
            System.out.println("登录成功！");
        }else{
            System.out.println(erro);
        }

    }
}
