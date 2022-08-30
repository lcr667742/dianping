package com.lee.dianping.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.dianping.entity.Seller;

import java.util.List;

/**
 *  商家服务类
 *
 * @author 61671
 * @since 2022-08-30
 */
public interface ISellerService extends IService<Seller> {

    /**
     * 商家新建
     *
     * @param seller 商家
     * @return 商家
     */
    Seller create(Seller seller);

    /**
     * 获取商家列表
     *
     * @return
     */
    List<Seller> getAllSeller();
}
