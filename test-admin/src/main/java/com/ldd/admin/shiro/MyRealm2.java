package com.ldd.admin.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * <p>功能描述：</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 刘大德</p>
 *
 * @author Mr.Liu
 * @version 1.0 2016/4/15 10:20
 */
public class MyRealm2 implements Realm {
    @Override
    public String getName() {
        return "myrealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        String password=new String((char[]) authenticationToken.getCredentials());
        if (!"ldd".equals(username)){
            throw new UnknownAccountException();//用户名错误
        }
        if(!"ldd".equals(password)){
            throw new IncorrectCredentialsException();//密码错误
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
