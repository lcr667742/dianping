package com.lee.dianping.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.Seller;
import com.lee.dianping.mapper.SellerMapper;
import com.lee.dianping.service.ISellerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  商家服务实现类
 *
 * @author 61671
 * @since 2022-08-30
 */
@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, Seller> implements ISellerService {

    @Override
    public Seller create(Seller seller) {

        this.save(seller);

        return seller;
    }

    @Override
    public List<Seller> getAllSeller() {
        return this.list();
    }

    @Override
    public int changeStatus(int id, int operate) throws BusinessException {
        Seller seller = this.getById(id);
        if(seller == null){
            throw new BusinessException(EmBusinessError.SELLER_NOT_EXIST);
        }

        LambdaUpdateWrapper<Seller> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Seller :: getDisabledFlag, operate)
                     .eq(Seller :: getId, id);

        boolean result = this.update(updateWrapper);

        return result ? 1 : 0;
    }
}
