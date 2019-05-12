package com.shgoods.goods.mapper;

import com.shgoods.goods.bean.Email;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

    Integer add(Email email);

    Integer update(Email email1);

    Email select(Email email);

}
