package com.shgoods.goods.realm;

import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lyq
 */
public class LoginRealm extends AuthorizingRealm {


    @Autowired
    ShUserService shUserService;

    @Override
    public String getName() {
        return "LoginRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("进来了 =222222222222");

        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        System.out.println(primaryPrincipal);

        return null;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal =(String) authenticationToken.getPrincipal();
        ShUser shUser = new ShUser();

        shUser.setUserNum(principal);
        ShUser login = shUserService.checkLogin(shUser);

        if(login==null){

            throw new UnknownAccountException("用户不存在");
        }
        if(login.getUserState()==0){

            throw new LockedAccountException("用户被锁定");
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(login,login.getUserPwd(), ByteSource.Util.bytes(login.getUserNum()),getName());
        return authenticationInfo;
    }
}
