package com.shgoods.goods.mapper.dto;

import com.shgoods.goods.dto.ClassInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 */
@Mapper
public interface ClassInfoDtoMapper {

    List<ClassInfoDto> findAll();
}
