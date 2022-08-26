package com.lee.dianping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.dianping.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper
 *
 * @author 61671
 * @since 2022-08-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 统计所有用户数量
     *
     * @return
     */
    int countAllUser();

}
