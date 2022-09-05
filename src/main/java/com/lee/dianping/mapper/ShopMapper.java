package com.lee.dianping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.dianping.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 门店Mapper
 * @Author 61671
 * @Date 2022/9/5 16:18
 * @Version 1.0.0
 */
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    /**
     * 获取门店列表
     *
     * @return
     */
    List<Shop> getAllWithAssociation();

}
