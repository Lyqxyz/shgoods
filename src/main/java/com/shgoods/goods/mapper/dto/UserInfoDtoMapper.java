package com.shgoods.goods.mapper.dto;

import com.shgoods.goods.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 * 用户相关
 */
@Mapper
public interface UserInfoDtoMapper {

    /**
     * 查询所有用户和学院(包括已删除，已禁用) 所需要的权限
     * @see UserInfoDto
     * @return List<UserInfoDto>
     */
    public List<UserInfoDto> findAllUser();

}
