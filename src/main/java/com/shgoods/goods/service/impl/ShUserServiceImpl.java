package com.shgoods.goods.service.impl;

import com.shgoods.goods.bean.UserRoleAuth;
import com.shgoods.goods.exception.FileUploadException;
import com.shgoods.goods.mapper.ShAuthorityRoleMapper;
import com.shgoods.goods.mapper.ShUserMapper;
import com.shgoods.goods.mapper.ShUserRoleMapper;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShUserService;
import com.shgoods.goods.util.FileUploadUtil;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.LoginVo;
import com.shgoods.goods.vo.RegVo;
import com.shgoods.goods.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.*;

/**
 * @author lyq
 */
@Service
@Slf4j
//@CacheConfig(cacheNames = "shuser", cacheManager = "SHUSERRedisCacheManager")
public class ShUserServiceImpl implements ShUserService {

    @Autowired
    ShUserMapper shUserMapper;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    ShUserRoleMapper shUserRoleMapper;

    @Autowired
    ShAuthorityRoleMapper shAuthorityRoleMapper;

    @Override
    public ResponseVo login(LoginVo loginVo, HttpServletRequest request, HttpSession session) {

        ResponseVo responseVo = new ResponseVo();

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {

            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginVo.getUsername(), loginVo.getPwd());
            try {
                currentUser.login(usernamePasswordToken);

//                currentUser.checkRole("admin");

                responseVo.setCode("1");

                responseVo.setMessage("登录成功");

                ShUser principal = (ShUser)currentUser.getPrincipal();

                principal.setUserLoginip(request.getRemoteAddr());

                Integer integer = this.afterLogin(principal);

                session.setAttribute("user",principal);

                responseVo.getInfo().put("user",principal);

            } catch (UnknownAccountException uae) {

                log.info(usernamePasswordToken.getPrincipal() + "账户不存在");
                responseVo.setCode("-1");
                responseVo.setMessage("账户不存在");

            } catch (LockedAccountException lae) {

                log.info(usernamePasswordToken.getPrincipal() + "用户被锁定了 ");
                responseVo.setCode("-1");
                responseVo.setMessage("用户被锁定了");

            } catch (IncorrectCredentialsException e) {

                log.info(usernamePasswordToken.getPrincipal() + "密码不正确");
                responseVo.setCode("-1");
                responseVo.setMessage("密码不正确");
            } catch (AuthenticationException ae) {
                responseVo.setCode("-1");
                responseVo.setMessage("服务器错误");
                log.info(ae.getMessage());
            }
        }
        responseVo.setDate(new Date());
        responseVo.setPath(request.getRequestURI());
        return  responseVo;

    }
    @Override
    public ShUser checkLogin(ShUser shUser) {

        return shUserMapper.login(shUser);
    }
    @Transactional
    @Override
    public Integer afterLogin(ShUser shUser) {

        return shUserMapper.afterLogin(shUser);
    }

    @Transactional
    @Override
    public ResponseVo register(RegVo regVo, HttpServletRequest request) {


        ResponseVo responseVo = new ResponseVo();

        ShUser shUser= new ShUser();

        shUser.setUserNum(regVo.getNum());

        shUser.setUserEmail(regVo.getEmail());

        shUser.setUserPhone(regVo.getPhone());

        //检查注册信息是否重复(学号,电话，邮箱)
        List<String> errors = this.attrsToCheck(shUser);

        if(errors.size()>0){

            responseVo.setCode("-1");
            responseVo.setMessage("注册失败");
            responseVo.getErrors().put("attrsErrors",errors);
            responseVo.setDate(new Date());
            responseVo.setPath(request.getRequestURI());

        }else {

            shUser.setUserName(regVo.getName());

            Md5Hash md5Hash = new Md5Hash(regVo.getPassword(), ByteSource.Util.bytes(regVo.getNum()),20);

            shUser.setUserPwd(md5Hash.toString());

            shUser.setUserGender(regVo.getGender());

            shUser.setUserRegip(request.getRemoteAddr());
            shUser.setUserState(1);
            Integer register = shUserMapper.register(shUser);
            responseVo.setCode("1");
            responseVo.setMessage("注册成功");
            responseVo.setDate(new Date());
            responseVo.setPath(request.getRequestURI());

        }
        return responseVo;
    }

    @Override
    public List<String> attrsToCheck(ShUser shUser) {

        List<String> errors= new ArrayList<>();
        if(shUser!=null){
            ShUser shUser1 = shUserMapper.checkShUserNum(shUser);

            ShUser shUser2 = shUserMapper.checkShUserPhone(shUser);

            ShUser shUser3 = shUserMapper.checkShUserEmail(shUser);

            if(shUser1!=null){

                errors.add("学号已被注册");
            }

            if(shUser2!=null){

                errors.add("电话已被注册");
            }

            if(shUser3!=null){
                errors.add("邮箱已被注册");
            }
        }
        return errors;
    }

    @Transactional
    @Override
    public ResponseVo forbidUser(ShUser shUser) {

        ResponseVo responseVo = new ResponseVo();
        if(shUser!=null&&shUser.getUserId()!=null){

            Integer integer = shUserMapper.forbidUser(shUser);
            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("禁用成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是禁用状态");
                responseVo.getErrors().put("errors",Arrays.asList("用户已经是禁用状态"));
            }

        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("禁用失败");
            responseVo.getErrors().put("errors",Arrays.asList("用户id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;
    }

    @Transactional
    @Override
    public ResponseVo delUser(ShUser shUser) {
        ResponseVo responseVo = new ResponseVo();

        if(shUser!=null&&shUser.getUserId()!=null){
            Integer integer = shUserMapper.forbidUser(shUser);
            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("删除成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是删除状态");
                responseVo.getErrors().put("errors",Arrays.asList("用户已经是删除状态"));
            }
        }else{

            responseVo.setCode("-1");
            responseVo.setMessage("删除失败");
            responseVo.getErrors().put("errors",Arrays.asList("用户id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;
    }

    @Override
    public ResponseVo addUser(ShUser shUser, MultipartFile file) {

        ResponseVo responseVo = new ResponseVo();

        responseVo.setDate(new Date());

        List<String> errors = this.attrsToCheck(shUser);

        if(errors.size()>0){

            responseVo.getErrors().put("errors",errors);

            responseVo.setCode("-1");

            responseVo.setMessage("添加失败");
        }else{

            Md5Hash md5Hash = new Md5Hash(shUser.getUserPwd(), ByteSource.Util.bytes(shUser.getUserNum()),20);

            shUser.setUserPwd(md5Hash.toString());

            String upload="";
            try {
                upload = fileUploadUtil.upload(file);

            } catch (IOException e) {

               throw new  FileUploadException("文件上传失败");
            }
            shUser.setUserPhoto(upload);
            Integer integer = shUserMapper.addUser(shUser);
            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("添加成功");
                responseVo.getInfo().put("path",upload);
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("添加失败");
                responseVo.getErrors().put("errors",Arrays.asList("非法添加"));
            }
        }

        return responseVo;
    }

    @Override
    public ResponseVo updatePhoto(ShUser shUser) {


        Integer integer = shUserMapper.updatePhoto(shUser);


        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("上传成功");

        return ok;

    }

    @Override
    public UserRoleAuth selectByUserId(String id) {

        ShUser shUser = new ShUser();

        shUser.setUserId("97977401056690245");

        ShUser allRole = shUserRoleMapper.findAllRole(shUser);

        List<ShAuthority> shAuthorities = shAuthorityRoleMapper.AllAuthByRoles(allRole.getShRoles());

        UserRoleAuth userRoleAuth = new UserRoleAuth();

        userRoleAuth.setShAuthorities(shAuthorities);

        userRoleAuth.setShRoles(allRole.getShRoles());


        return userRoleAuth;


    }

}
