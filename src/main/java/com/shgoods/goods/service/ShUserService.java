package com.shgoods.goods.service;

import com.shgoods.goods.bean.UserRoleAuth;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.vo.LoginVo;
import com.shgoods.goods.vo.RegVo;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.List;
import java.util.Map;

public interface ShUserService {
    /**
     *
     * 登录验证
     * @param loginVo
     * @param request
     * @param session
     * @return
     */
     ResponseVo login(LoginVo loginVo, HttpServletRequest request, HttpSession session);
    /**
     * 登录验证 查询用户
     * @param shUser
     * @return
     */
     ShUser checkLogin(ShUser shUser);

     Integer afterLogin(ShUser shUser);

    /**
     * 注册用户
     * @param regVo
     * @param request
     * @return
     */
     ResponseVo register(RegVo regVo,HttpServletRequest request);

    /**
     * 注册前校验
     * @return
     */
     List<String> attrsToCheck(ShUser shUser);

    /**
     * 禁用用户
     * @param shUser
     * @return
     */
     ResponseVo forbidUser(ShUser shUser);

    /**
     * 删除用户(逻辑删除)
     * @param shUser
     * @return
     */
     ResponseVo delUser(ShUser shUser);

    /**
     * 增加用户
     * @param shUser file
     * @return
     */
     ResponseVo addUser(ShUser shUser, MultipartFile file);


     ResponseVo updatePhoto(ShUser shUser);

     UserRoleAuth selectByUserId(String id);

     ResponseVo indexLogin(LoginVo loginVo, HttpServletRequest request, HttpSession session);

}
