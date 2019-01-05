package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.vo.LoginVo;
import com.shgoods.goods.vo.RegVo;
import com.shgoods.goods.vo.ResponseVo;

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
    public ResponseVo login(LoginVo loginVo, HttpServletRequest request, HttpSession session);

    /**
     * 登录验证 查询用户
     * @param shUser
     * @return
     */
    public ShUser checkLogin(ShUser shUser);

    public Integer afterLogin(ShUser shUser);


    /**
     * 注册用户
     * @param regVo
     * @param request
     * @return
     */
    public ResponseVo register(RegVo regVo,HttpServletRequest request);

    /**
     * 注册前校验
     * @return
     */
    public List<String> attrsToCheck(ShUser shUser);


    /**
     * 禁用用户
     * @param shUser
     * @return
     */
    public ResponseVo forbidUser(ShUser shUser);

    /**
     * 删除用户(逻辑删除)
     * @param shUser
     * @return
     */
    public ResponseVo delUser(ShUser shUser);


    /**
     * 增加用户
     * @param shUser
     * @return
     */
    public ResponseVo addUser(ShUser shUser);


}
